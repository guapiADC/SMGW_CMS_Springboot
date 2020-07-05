package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BookRegisterDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pedro@TaleLin
 */
@Repository
public interface BookRegisterMapper extends BaseMapper<BookRegisterDO> {

    List<BookRegisterDO> selectByBookNameLikeKeyword(@Param("q") String q);

    List<BookRegisterDO> selectByBookName(@Param("bookName") String bookName);
}
