package com.jf.controller.user;

import com.jf.model.Book;
import com.jf.model.BookType;
import com.jf.service.BookService;
import com.jf.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JF on 2016/6/11.
 */
@Controller
@RequestMapping("book")
public class BookUserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;


    /**
     * 跳到推荐图书首页
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("index.jhtml")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response,BookType bookType){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        List<BookType> bookTypes = bookTypeService.getBookTypeList(bookType);
        model.addAttribute("bookTypes",bookTypes);
        return "book/index";
    }

}
