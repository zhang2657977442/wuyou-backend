package com.example.wuyou.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.example.wuyou.utils.FormatUtils;

@MappedJdbcTypes(JdbcType.DOUBLE)
@MappedTypes(Date.class)
@Slf4j
public class DateTypeHandler implements TypeHandler<Date> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        log.info("method ====>>> setParameter");
     ps.setDouble(i,new FormatUtils().getTimeStampDouble(parameter.getTime()));
    }
    //下面三个则是，从数据库加载数据后，vo对象封装前的数据处理
    public Date getResult(ResultSet rs, String columnName)
            throws SQLException {
        log.info("method ====>>> getResult(ResultSet rs, String columnName)");
        long timeStamp =  new FormatUtils().getTimeStampLong(rs.getDouble(columnName));
        return new Date(timeStamp);
    }
    public Date getResult(ResultSet rs, int columnIndex)
            throws SQLException {
        log.info("method ====>>> getResult(ResultSet rs, int columnIndex)");
        long timeStamp =  new Double(rs.getDouble(columnIndex)).longValue();
        return new Date(timeStamp);
    }
    public Date getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        log.info("method ====>>> getResult(CallableStatement cs, int columnIndex)");
        long timeStamp =  new Double(cs.getDouble(columnIndex)).longValue();
        return new Date(timeStamp);
    }
}
