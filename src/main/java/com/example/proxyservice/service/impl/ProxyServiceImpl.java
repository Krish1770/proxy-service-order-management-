package com.example.proxyservice.service.impl;

import com.example.proxyservice.FeignClients.BillCollaboration;
import com.example.proxyservice.dto.*;
import com.example.proxyservice.service.ProxyService;
import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private BillCollaboration billCollaboration;
    @Override
    public ResponseEntity<ResponseDTO> createBills(BillDto billDto) throws MessagingException, ExecutionException, InterruptedException {

        System.out.println(billDto.getEmailId()+" "+billDto.getOrderItems());
        System.out.println("Bill     "  +billDto);
        ResponseEntity<ResponseDTO> responseDTOResponseEntity = billCollaboration.createBills(billDto);
       String ans= responseDTOResponseEntity.getBody().getData().toString();
        System.out.println("my ans"+responseDTOResponseEntity.getBody().getData().toString());

//        System.out.println("healthApi   :5"+billCollaboration.health());
//        System.out.println("result"+ responseDTOResponseEntity);
//        System.out.println("BillId"+billId);

      return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("bill generated",ans,HttpStatus.OK)));
    }

    @Override
    public void generateMail(GenerateMailDTO generateMailDTO) {


        SimpleMailMessage message = new SimpleMailMessage();

        System.out.println("proceesing the mail");

            System.out.println("step3");
//    Formatter formatter=new Formatter();
//    String result="";String uid="customerId :"+bill.getUserName()+"\n";
//     String bid="billId :"+id+"\n";
//    formatter.format("%15s %15s %15s %15s\n","name","price","quantity","Gst");
//
//    System.out.println(bill.getOrderItems());
//    for(ResponseOrderItems items :bill.getOrderItems())
//    {
//      int space2=20-items.getAmount().toString().length();
//      int space1=18-items.getItem().length();
//      int space3=15- items.getQuantity().toString().length();
//      int space4=23-items.getGst().toString().length();
//      formatter.format("%"+space1+"s %"+(space2)+"s %"+space3+"s  %"+(space4-3)+"s\n ",items.getItem(),items.getAmount(),items.getQuantity(),items.getGst().toString().substring(0,4)+"%");
//      result+=formatter;
//    }
//
//    System.out.println(formatter.toString());
//    message.setText(uid+bid+formatter+
//            bill.getOrder().getAmount());
//    javaMailSender.send(message);

            MimeMessage message1 = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message1, "utf-8");
        System.out.println(generateMailDTO);

            StringBuilder str = new StringBuilder();

            str.append("<html><body>"
                    + "<table style='border:2px solid black'>");
//
//    str.append("<tr>");
//    str.append("<th>name</th>");
//    str.append("<th>price</th>");
//    str.append("<th>quantity</th>");
//    str.append("<th>GST</>");
//    for(ResponseOrderItems items :bill.getOrderItems())
//    {
//      str.append("<tr>");
//      str.append("<td>");
//      str.append(items.getItem());
//      str.append("</td>");
//      str.append("<td>");
//      str.append(items.getAmount());
//      str.append("</td>");
//      str.append("<td>");
//      str.append(items.getQuantity());
//      str.append("</td>");
//      str.append("<td>");
//      str.append(items.getGst());
//      str.append("</td>");
//      str.append("</tr>");
//    }
//    str.append("</table></body></html>");
//
//    helper.setFrom("rameshkrishnaprasath@gmail.com");
//    helper.setTo(emailId);
//
//
//    System.out.println(str);
//    helper.setText(str.toString());
//    javaMailSender.send(message);

            String[][] data = {{"1", "2"}, {"3", "4"}};
        sendTableEmail(generateMailDTO.getEmailId(), generateMailDTO.getBill(), generateMailDTO.getId());


    }

    public void sendTableEmail(String to, Bill bill, String id) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
        System.out.println("message"+to);
        try {
            messageHelper.setTo(to);

            String res = "name: " + bill.getUserName() + "\n" + "bill-Id :" + bill.getId();


            res += buildHtmlTable(bill);
            messageHelper.setTo(to);
            messageHelper.setSubject("your generated bill from our side");
            messageHelper.setText(res, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private String buildHtmlTable(Bill bill) {
        StringBuilder str = new StringBuilder();
        str.append("<html><body><table border='1'>");

        double tot = 0;
        str.append("<tr>");
        str.append("<th>name</th>");
        str.append("<th>price</th>");
        str.append("<th>quantity</th>");
        str.append("<th>GST</th>");
        str.append("<th>Amount</th>");
        for (ResponseOrderItems items : bill.getOrderItems()) {
            str.append("<tr>");
            str.append("<td>");
            str.append(items.getItem());
            str.append("</td>");
            str.append("<td>");
            str.append(items.getAmount());
            str.append("</td>");
            str.append("<td>");
            str.append(items.getQuantity());
            str.append("</td>");
            str.append("<td>");
            str.append(items.getGst().toString().substring(0, 5) + "%");
            str.append("</td>");
            str.append("<td>");
            Double ert = (items.getAmount() * items.getQuantity()) + (double) (items.getAmount()) / 100 * items.getGst().doubleValue() * items.getQuantity();
            str.append(ert);
            tot += ert;
            str.append("</td>");
            str.append("</tr>");
        }


        str.append("</table></body></html>");

        str.append("total :" + tot);
        return str.toString();
    }
}


