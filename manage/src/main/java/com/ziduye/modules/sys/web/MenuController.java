package com.ziduye.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziduye.utils.bean.MsgModel;
import com.ziduye.base.web.CrudContrller;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.service.MenuService;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "sys/menu")
public class MenuController {

    @ResponseBody
    @RequestMapping("/test")
    public String menu(){
        StringBuffer sb = new StringBuffer();
        sb.append("<ul>");
        sb.append("<li class=\"\">");
        sb.append("<a href=\"ajax/dashboard.html\" title=\"仪表盘\">");
        sb.append("<i class=\"fa fa-lg fa-fw fa-home\"></i>");
        sb.append("<span class=\"menu-item-parent\">仪表盘</span>");
        sb.append("</a>");
        sb.append("</li>");

        sb.append("<li>");
        sb.append("<a href=\"ajax/inbox.html\">");
        sb.append("<i class=\"fa fa-lg fa-fw fa-inbox\"></i>");
        sb.append("<span class=\"menu-item-parent\">收件箱</span><span class=\"badge pull-right inbox-badge\">14</span>");
        sb.append("</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='#'>");
        sb.append("<i class='fa fa-lg fa-fw fa-bar-chart-o'></i>");
        sb.append("<span class='menu-item-parent'>图表</span>");
        sb.append("</a>");
        sb.append("<ul>");
        sb.append("<li>");
        sb.append("<a href='ajax/flot.html'>Flot Chart</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/morris.html'>Morris Charts</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/inline-charts.html'>Inline Charts</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/dygraphs.html'>Dygraphs</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/chartjs.html'>Chart.js <span class='badge pull-right inbox-badge bg-color-yellow'>new</span></a>");
        sb.append("</li>");
        sb.append("</ul>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='#'>");
        sb.append("<i class='fa fa-lg fa-fw fa-table'></i>");
        sb.append("<span class='menu-item-parent'>表格</span>");
        sb.append("</a>");
        sb.append("<ul>");
        sb.append("<li>");
        sb.append("<a href='ajax/table.html'>普通表格</a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/datatables.html'>数据表格 <span class='badge inbox-badge bg-color-greenLight'>v1.10</span></a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/ces.html'>测试 <span class='badge inbox-badge bg-color-greenLight'>v1.10</span></a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/ces3.html'>测试3 </a>");
        sb.append("</li>");
        sb.append("<li>");
        sb.append("<a href='ajax/jqgrid.html'>Jquery Grid</a>");
        sb.append("</li>");
        sb.append("</ul>");
        sb.append("</li>");
        sb.append("</ul>");
        return sb.toString();
    }
}
