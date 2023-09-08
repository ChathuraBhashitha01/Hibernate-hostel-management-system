package lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.dao.impl.QueryDAO;
import lk.ijse.hibernate.hostalManagementSystem.dto.CustomEntityDTO;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<CustomEntityDTO> getAll() {
        String sql = "SELECT res_id, res_date, r.room_type_id, r.type, s.id, s.name, r.key_money, status " +
                "FROM reservation " +
                "INNER JOIN student s on reservation.student_id = s.id " +
                "INNER JOIN room r on reservation.room_type_id = r.room_type_id " +
                "ORDER BY CAST(SUBSTRING(res_id, 3) AS UNSIGNED)";
        NativeQuery sqlQuery = session.createNativeQuery(sql);


//        sqlQuery.addScalar("res_id", SaslPrep.StringType);
//        sqlQuery.addScalar("res_date", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("room_type_id", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("type", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("id", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("name", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("key_money", SaslPrep.StringType.INSTANCE);
//        sqlQuery.addScalar("status", SaslPrep.StringType.INSTANCE);

        sqlQuery.setResultTransformer(Transformers.aliasToBean(CustomEntityDTO.class));

        List<CustomEntityDTO> customEntities = sqlQuery.list();
        ArrayList<CustomEntityDTO> customData = new ArrayList<>();

        for (CustomEntityDTO entity : customEntities) {
            customData.add(entity);
        }

        return customData;
    }
}
