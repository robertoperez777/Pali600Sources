package org.kep.cemetery.web;
import org.kep.cemetery.domain.ChurchMaintenance;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/churchmaintenances")
@Controller
@RooWebScaffold(path = "churchmaintenances", formBackingObject = ChurchMaintenance.class)
public class ChurchMaintenanceController {
}
