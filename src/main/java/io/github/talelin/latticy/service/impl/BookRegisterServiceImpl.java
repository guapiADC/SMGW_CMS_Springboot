package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.book.CreateOrUpdateBookRegisterDTO;
import io.github.talelin.latticy.mapper.BookRegisterMapper;
import io.github.talelin.latticy.model.BookRegisterDO;
import io.github.talelin.latticy.service.BookRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRegisterServiceImpl implements BookRegisterService {

    @Autowired
    BookRegisterMapper bookRegisterMapper;

    @Override
    public boolean createBookRegister(CreateOrUpdateBookRegisterDTO validator) {
        BookRegisterDO bookRegister = new BookRegisterDO();
        bookRegister.setBookName(validator.getBookName());
        bookRegister.setDescrible(validator.getDescrible());
        bookRegister.setState(validator.getState());
        bookRegister.setBookNo(validator.getBookNo());
        bookRegister.setBorrowerName(validator.getBorrowerName());
        bookRegister.setBorrowerIphone(validator.getBorrowerIphone());
        bookRegister.setBookImagesUrl(validator.getBookImagesUrl());
        return bookRegisterMapper.insert(bookRegister)>0;
    }

    @Override
    public List<BookRegisterDO> getBookRegisterByKeyword(String q) {
        List<BookRegisterDO>  bookRegisterDOList  =  bookRegisterMapper.selectByBookNameLikeKeyword(q);
        return bookRegisterDOList;
    }

    @Override
    public boolean updateBookRegister(BookRegisterDO bookRegister, CreateOrUpdateBookRegisterDTO validator) {
        bookRegister.setBookName(validator.getBookName());
        bookRegister.setDescrible(validator.getDescrible());
        bookRegister.setState(validator.getState());
        bookRegister.setBookNo(validator.getBookNo());
        bookRegister.setBorrowerName(validator.getBorrowerName());
        bookRegister.setBorrowerIphone(validator.getBorrowerIphone());
        bookRegister.setBookImagesUrl(validator.getBookImagesUrl());
        return bookRegisterMapper.updateById(bookRegister)>0;
    }

    @Override
    public BookRegisterDO getById(Long id) {
        BookRegisterDO bookRegisterDO = bookRegisterMapper.selectById(id);
        return bookRegisterDO;
    }

    @Override
    public List<BookRegisterDO> findAll() {
        List<BookRegisterDO> bookRegisterDOList = bookRegisterMapper.selectList(null);
        return bookRegisterDOList;
    }

    @Override
    public boolean deleteById(Long id) {

        return bookRegisterMapper.deleteById(id)>0;
    }
}
