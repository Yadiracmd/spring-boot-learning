package com.ztf.boot.task.utils;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ztf.boot.task.mapper.CreateMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@Component
public class CreateUtils {

    @Resource
    private CreateMapper createMapper;

    @Value("${upload.path}")
    private String path;

    @GetMapping("/g")
    public void get() {

        // 获取日期路径
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedString = date.format(formatter);
        System.out.println(formattedString);

        // 获取所有的数据库
        List<String> tables = createMapper.getTableList();

        for (String table : tables) {
            System.out.println(table);
            List<Map<String, Object>> datas = createMapper.getDates(table);
            String tablePath = path + "/" + formattedString + "/" + table + ".xlsx";
            for (Map<String, Object> data : datas) {
                System.out.println(data);
            }

            // 通过工具类创建writer
            ExcelWriter writer = ExcelUtil.getWriter(tablePath);
            // 合并单元格后的标题行，使用默认标题样式
            // 一次性写出内容，使用默认样式，强制输出标题
            writer.write(datas, true);
            // 关闭writer，释放内存
            writer.close();
        }


    }
}
