package io.github.talelin.latticy.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateBookRegisterDTO {

    @NotEmpty(message = "{bookregister.bookName.not-empty}")
    @Size(max = 50, message = "{bookregister.bookName.size}")
    private String bookName;


    @NotEmpty(message = "{bookregister.describle.not-empty}")
    @Size(max = 1000, message = "{bookregister.describle.size}")
    private String describle;

    @Size(max = 1000, message = "{bookregister.bookImagesUrl.size}")
    private String bookImagesUrl;

    @Size(max = 50, message = "{bookregister.borrowerName.size}")
    private String borrowerName;

    @Size(max = 50, message = "{bookregister.borrowerIphone.size}")
    private String borrowerIphone;

    @NotEmpty(message = "{bookregister.state.not-empty}")
    @Size(max = 50, message = "{bookregister.state.size}")
    private String state;

    @NotEmpty(message = "{bookregister.bookNo.not-empty}")
    @Size(max = 50, message = "{bookregister.bookNo.size}")
    private String bookNo;



}
