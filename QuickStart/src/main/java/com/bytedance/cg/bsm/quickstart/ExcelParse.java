package com.bytedance.cg.bsm.quickstart;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ObjectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/2  15:06
 */
public class ExcelParse {
    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("/Users/bytedance/Downloads/FAQ兜底.xlsx");
             Workbook workBook = new XSSFWorkbook(in)) {
            Sheet sheet0 = workBook.getSheetAt(0);// 获取Sheet工作簿
            Row row = sheet0.getRow(0);// 获取行
            Cell cell = row.getCell(0);
            String str = cell.getStringCellValue();// 如果单元格中的数据时字符串
            System.out.println(str);
            System.out.println(row.getCell(1).getStringCellValue());
            int last = sheet0.getLastRowNum();
            System.out.println(last);
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i <= last; i++) {
                Integer category = (int) sheet0.getRow(i).getCell(0).getNumericCellValue();
                List<Integer> list = map.get(category);
                if (ObjectUtils.isEmpty(list)) {
                    list = new ArrayList<>();
                }
                Integer faqid = (int) sheet0.getRow(i).getCell(1).getNumericCellValue();
                list.add(faqid);
                map.put(category, list);
            }
            System.out.println(map);

            List<JSONObject> json = new ArrayList<>();

            Set<Integer> keySet = map.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = new JSONObject();
                Integer next = iterator.next();
                jsonObject.put("category_id", next);
                List<Integer> faqlist = map.get(next);
                jsonObject.put("faq_ids", faqlist);
                System.out.println(jsonObject);
                json.add(jsonObject);
            }
            JSONObject req = new JSONObject();
            req.put("recommend_detail", json);
            System.out.println(req);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
