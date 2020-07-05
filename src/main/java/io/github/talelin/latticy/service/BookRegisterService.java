package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.book.CreateOrUpdateBookRegisterDTO;
import io.github.talelin.latticy.model.BookRegisterDO;

import java.util.List;

/**
 * @author pedro@TaleLin
 */
public interface BookRegisterService {

    boolean createBookRegister(CreateOrUpdateBookRegisterDTO validator);

    List<BookRegisterDO> getBookRegisterByKeyword(String q);

    boolean updateBookRegister(BookRegisterDO book, CreateOrUpdateBookRegisterDTO validator);

    BookRegisterDO getById(Long id);

    List<BookRegisterDO> findAll();

    boolean deleteById(Long id);
}
