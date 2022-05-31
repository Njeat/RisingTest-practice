package com.example.demo.src.user;


import com.example.demo.src.sms.model.Sms;
import com.example.demo.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetUserRes> getUsers(){
        String getUsersQuery = "select * from UserInfo";
        return this.jdbcTemplate.query(getUsersQuery,
                (rs,rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("profileImgUrl"),
                        rs.getString("userName"),
                        rs.getString("phoneNum"),
                        rs.getString("status"))
                );
    }

    public List<GetUserRes> getUsersByPhoneNum(String phoneNum){
        String getUsersByPhoneNumQuery = "select * from UserInfo where phoneNum =?";
        String getUsersByPhoneNumParams = phoneNum;
        return this.jdbcTemplate.query(getUsersByPhoneNumQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("profileImgUrl"),
                        rs.getString("userName"),
                        rs.getString("phoneNum"),
                        rs.getString("status")),
                getUsersByPhoneNumParams);
    }

    public GetUserRes getUser(int userIdx){
        String getUserQuery = "select * from UserInfo where userIdx = ?";
        int getUserParams = userIdx;
        return this.jdbcTemplate.queryForObject(getUserQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("profileImgUrl"),
                        rs.getString("userName"),
                        rs.getString("phoneNum"),
                        rs.getString("status")),
                getUserParams);
    }
    

    public int createUser(PostUserReq postUserReq){
        String createUserQuery = "insert into UserInfo (profileImgUrl, userName, phoneNum) values (?,?,?)";
        Object[] createUserParams = new Object[]{postUserReq.getProfileImgUrl(), postUserReq.getUserName(), postUserReq.getPhoneNum()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery,int.class);
    }

    public int checkPhoneNum(String phoneNum){
        String checkPhoneNumQuery = "select exists(select phoneNum from UserInfo where phoneNum = ?)";
        String checkPhoneNumParams = phoneNum;
        return this.jdbcTemplate.queryForObject(checkPhoneNumQuery,
                int.class,
                checkPhoneNumParams);

    }

    public int modifyUserName(PatchUserReq patchUserReq){
        String modifyUserNameQuery = "update UserInfo set userName = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getUserName(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserNameQuery,modifyUserNameParams);
    }
//    public User getPhoneNum(PostLoginReq postLoginReq){
//        String getPhoneNumQuery = "select userIdx, phoneNum, userName from UserInfo where phoneNum = ?";
//        String getPwdParams = postLoginReq.getPhoneNum();
//    }

//    public User getPwd(PostLoginReq postLoginReq){
//        String getPwdQuery = "select userIdx, password,email,userName,id from UserInfo where id = ?";
//        String getPwdParams = postLoginReq.getId();
//
//        return this.jdbcTemplate.queryForObject(getPwdQuery,
//                (rs,rowNum)-> new User(
//                        rs.getInt("userIdx"),
//                        rs.getString("id"),
//                        rs.getString("userName"),
//                        rs.getString("password"),
//                        rs.getString("email")
//                ),
//                getPwdParams
//                );
//    }



}
