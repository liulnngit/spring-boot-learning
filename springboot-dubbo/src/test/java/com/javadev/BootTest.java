package com.javadev;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = BasicServiceApplication.class)
@RunWith(SpringRunner.class)
public class BootTest {

    @Value("${mybatis.typeAliasesPackage}")
    private String msg;
    
    @Test
    public void testConfig() {
        System.err.println("msg : " + msg);
    }
    
    /*@Autowired
    IGoodsService goodsService;

    @Test
    public void testGoodsInsert(){
        Goods goods = new Goods();
        goods.setZsspId("123456");
        goods.setMerchantId("No.9527");
        goods.setGoodsCode("HYYD001");
        goods.setCompanyGoodsCode("HYY00111");
        goods.setGoodsName("万宝路");
        goods.setSpecificationModel("XXX");
        goods.setMeasureUnit("条");
        goods.setPrice(new BigDecimal("52.56"));
        goods.setTaxRate(new BigDecimal("0.06"));
        goods.setZeroRateFlag("");
        goods.setGoodsClassification("日用品");
        goods.setBenifitFlag("0");
        goods.setBenifitInstruction(null);
        goods.setCreatorId(1);
        goods.setCreateDate(System.currentTimeMillis());
        goods.setUpdaterId(1);
        goods.setUpdateDate(System.currentTimeMillis());
        goodsService.insert(goods);
        System.out.println("保存成功!");
    }*/

    /*@Reference(version = "1.0.0")
    IProxyService iProxyService;

    @Test
    public void testService() {
        Proxy proxy = iProxyService.selectByPrimaryKey("");
    }*/
    
}
