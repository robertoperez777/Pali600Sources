package org.kep.cemetery.web;
import org.kep.cemetery.domain.PhoneNumber;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/phonenumbers")
@Controller
@RooWebScaffold(path = "phonenumbers", formBackingObject = PhoneNumber.class)
public class PhoneNumberController {
}
