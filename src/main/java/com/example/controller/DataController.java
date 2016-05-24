package com.example.controller;

import com.example.service.DataService;
import com.example.utils.Ajax;
import com.example.utils.ExceptionHandlerController;
import com.example.utils.RestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pavelbortnikov on 06.04.16.
 */

@Controller
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(DataController.class);

    @Autowired
    @Qualifier("dataService")
    private DataService dataService;

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> persist(@RequestParam("first_name") String firstName,
                                @RequestParam("password") String password) throws RestException {
        try {
            if(dataService.isLoginCorrect(firstName, password))
                if("admin".equals(firstName))
                    return Ajax.successResponse("/prices_edit.html");
                else
                    return Ajax.successResponse("/prices.html");
            else
                return Ajax.errorResponse("Ошибка! Проверьте учетные данные!");
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getData() throws RestException {
        try {
            Map<String,String> result = dataService.getPrices();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/savePrice", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> savePrice(@RequestParam("ai_92") String ai_92,
                                  @RequestParam("ai_95") String ai_95,
                                  @RequestParam("ai_98") String ai_98,
                                  @RequestParam("disel") String disel) throws RestException {
        try {
            Map<String, String> prices = new HashMap<>();
            prices.put("ai_92", ai_92);
            prices.put("ai_95", ai_95);
            prices.put("ai_98", ai_98);
            prices.put("disel", disel);
            boolean result = dataService.setPrices(prices);
            return Ajax.successResponse("Цены успшно сохранены!");
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
}