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
import javax.servlet.http.HttpSession;
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

    @Autowired
    private HttpSession session;

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
        if (books.size()>0){
            for (int i=0;i<books.size();i++){
                books.get(i).setTypeName(bookTypeService.getBookTypeName(books.get(i).getBookType()));
            }
        }
        model.addAttribute("books",books);
        List<BookType> bookTypes = bookTypeService.getBookTypeList(bookType);
        model.addAttribute("bookTypes",bookTypes);
        session = request.getSession();
        if (session.getAttribute("type")!=null && session.getAttribute("type").equals("")==false){
            model.addAttribute("type",session.getAttribute("type"));
        }
        return "book/index";
    }



}
