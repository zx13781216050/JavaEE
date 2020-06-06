package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Address_Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Address_InfoMapper {
    @Select("select * from address_info where b_s_id = #{b_s_id}")
    List<Address_Info> getAddressList(int b_s_id);
    @Select("select count(*) as nums from address_info where b_s_id = #{b_s_id}")
    int getAddressNums(int b_s_id);
    @Update("update address_info set default_status = 0 where default_status = 1 and " +
            " b_s_id = #{b_s_id}")
    int updateDefaultStatus(int b_s_id);
    @Insert("insert into address_info (b_s_id, address, address_detail, addresssee, " +
            " telephone, postcode, default_status) values(#{b_s_id}, #{address}, #{address_detail}, " +
            " #{addresssee},#{telephone},#{postcode},#{default_status})")
    int insertAddress(Address_Info address_info);
}
