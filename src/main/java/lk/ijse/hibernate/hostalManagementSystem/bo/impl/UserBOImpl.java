package lk.ijse.hibernate.hostalManagementSystem.bo.impl;

import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.UserDAO;
import lk.ijse.hibernate.hostalManagementSystem.dto.UserDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


//public class UserBOImpl {
//    private static UserBOImpl userBOImpl;
//    private final UserDAO userDAO;
//
//    private UserBOImpl() {
//         userDAO = (UserDAO) new U();
//    }
//
//    public static UserBOImpl getInstance() {
//        return null == userBOImpl
//                ? userBOImpl = new UserBOImpl()
//                : userBOImpl;
//    }
//
//    public User get(String user) {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try{
//            userDAO.setSession(session);
//            User list= userDAO.get(user);
//            transaction.commit();
//            session.close();
//            return list;
//
//        }catch (Exception e){
//            return null;
//        }
//    }
//
//    public int update(UserDTO userDTO) {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            userDAO.setSession(session);
//            userDAO.save(userDTO.toEntity());
//            transaction.commit();
//            session.close();
//            //return roomID;
//             return 1;
//        } catch (Exception e) {
//            transaction.rollback();
//            session.close();
//            e.printStackTrace();
//            return -1;
//        }
//    }
//}
