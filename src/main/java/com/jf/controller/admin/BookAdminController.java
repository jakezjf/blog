package com.jf.controller.admin;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by JF on 2016/6/15.
 */
@Controller
@RequestMapping("/book")
public class BookAdminController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 遍历所有书籍
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("index.do")
    public String index(HttpServletRequest request, ModelMap model, HttpServletResponse response){
        List<Book> books = bookService.getBooks();
        if (books.size()>0){
            for (int i=0 ;i<books.size() ;i++ ){
                if (books.get(i).getBookType()!=null && books.get(i).getBookType().equals("")==false)
                books.get(i).setTypeName(bookTypeService.getBookTypeName(books.get(i).getBookType()));
            }
        }
        model.addAttribute("books",books);
        return "book/bookList";
    }

    /**
     * 根据id，删除书籍
     * @param book
     * @return
     */
    @RequestMapping("delete.do")
    public String delete(Book book){
        bookService.delete(book);
        return "redirect:index.do";
    }

    /**
     * 跳转修改书籍界面
     * @param book
     * @param model
     * @return
     */
    @RequestMapping("toUpdate.do")
    public String toUpdate(Book book,ModelMap model){
        model.addAttribute("book",book);
        return "book/update";
    }

    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    @RequestMapping("update.do")
    public String update(Book book){
        bookService.update(book);
        return "redirect:index.do";
    }

    @RequestMapping("toAdd.do")
    public String toAdd(ModelMap model,BookType bookType){
        List<BookType> bookTypes = bookTypeService.getBookTypeList(bookType);
        model.addAttribute("bookTypes",bookTypes);
        return "book/add";
    }


    /**
     * 添加书籍
     * @param book
     * @return
     */
    @RequestMapping("add.do")
    public String add(Book book,String addTimeString){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(addTimeString);
            book.setAddTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookService.insert(book);
        return "redirect:index.do";
    }



}
