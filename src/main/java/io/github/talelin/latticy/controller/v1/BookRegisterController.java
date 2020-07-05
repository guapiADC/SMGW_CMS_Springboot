package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupMeta;
import io.github.talelin.latticy.dto.book.CreateOrUpdateBookDTO;
import io.github.talelin.latticy.dto.book.CreateOrUpdateBookRegisterDTO;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.model.BookRegisterDO;
import io.github.talelin.latticy.service.BookRegisterService;
import io.github.talelin.latticy.service.BookService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author pedro@TaleLin
 */
@RestController
@RequestMapping("/v1/bookregister")
@Validated
public class BookRegisterController {

    @Autowired
    private BookRegisterService bookRegisterService;

    @GetMapping("/{id}")
    public BookRegisterDO getBookRegister(@PathVariable(value = "id") @Positive(message = "{id}") Long id) {
        BookRegisterDO bookRegister = bookRegisterService.getById(id);
        if (bookRegister == null) {
            throw new NotFoundException("bookRegister not found", 10022);
        }
        return bookRegister;
    }

    @GetMapping("")
    public List<BookRegisterDO> getBookRegister() {
        List<BookRegisterDO> bookRegisterList = bookRegisterService.findAll();
        return bookRegisterList;
    }


    @GetMapping("/search")
    public List<BookRegisterDO> searchBookRegister(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        List<BookRegisterDO> bookRegisterList = bookRegisterService.getBookRegisterByKeyword("%" + q + "%");
        return bookRegisterList;
    }


    @PostMapping("")
    public CreatedVO createBookRegister(@RequestBody @Validated CreateOrUpdateBookRegisterDTO validator) {
        bookRegisterService.createBookRegister(validator);
        return new CreatedVO(12);
    }


    @PutMapping("/{id}")
    public UpdatedVO updateBookRegister(@PathVariable("id") @Positive(message = "{id}") Long id, @RequestBody @Validated CreateOrUpdateBookRegisterDTO validator) {
        BookRegisterDO bookRegister = bookRegisterService.getById(id);
        if (bookRegister == null) {
            throw new NotFoundException("bookRegister not found", 10022);
        }
        bookRegisterService.updateBookRegister(bookRegister, validator);
        return new UpdatedVO(13);
    }


    @DeleteMapping("/{id}")
    @GroupMeta(permission = "删除图书", module = "图书", mount = true)
    public DeletedVO deleteBookRegister(@PathVariable("id") @Positive(message = "{id}") Long id) {
        BookRegisterDO bookRegister = bookRegisterService.getById(id);
        if (bookRegister == null) {
            throw new NotFoundException("bookRegister not found", 10022);
        }
        bookRegisterService.deleteById(bookRegister.getId().longValue());
        return new DeletedVO(14);
    }


}
