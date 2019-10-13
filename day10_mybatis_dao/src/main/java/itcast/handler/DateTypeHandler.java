package itcast.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    //java转sql
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i,time);
    }
    //sql转java
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //根据列名从结果集获取结果
        long birthday = rs.getLong(columnName);
        Date date=new Date(birthday);
        return date;
    }

    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long birthday = rs.getLong(columnIndex);
        Date date=new Date(birthday);
        return date;
    }

    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long birthday = cs.getLong(columnIndex);
        Date date=new Date(birthday);
        return date;
    }
}
