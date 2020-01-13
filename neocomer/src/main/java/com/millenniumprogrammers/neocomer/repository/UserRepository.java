package com.millenniumprogrammers.neocomer.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Usuario;

@Service
@Mapper
public interface UserRepository  {

	@Select("")
	Usuario findOneByUsername(String username);
}
