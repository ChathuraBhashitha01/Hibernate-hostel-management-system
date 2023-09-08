package lk.ijse.hibernate.hostalManagementSystem.bo;

import lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom.ReservationBOImpl;
import lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom.RoomBOImpl;
import lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private static StudentBOImpl studentBoImpl;
    private static ReservationBOImpl reservationBoImpl;
    private static RoomBOImpl roomBoImpl;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory==null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BoType {
        STUDENT,ROOM,RESERVATION
    }

    public <SuperBo>SuperBo getBo(BoType boType){
        switch(boType){
            case STUDENT:
                return (SuperBo) ((studentBoImpl==null) ? studentBoImpl = new StudentBOImpl() : studentBoImpl);
            case ROOM:
                return (SuperBo) ((roomBoImpl==null) ? roomBoImpl = new RoomBOImpl() : roomBoImpl);
            case RESERVATION:
                return (SuperBo) ((reservationBoImpl == null) ? reservationBoImpl = new ReservationBOImpl() : reservationBoImpl);
            default:
                return null;
        }
    }
}
