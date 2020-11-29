package gentor;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Gentor {

//    INSERT into t_soft_category (id,category_name ,category_desc )values('1','JAVA','');
//    INSERT into t_soft_category (id,category_name ,category_desc )values('2','前端','');
    public static void main(String[] args) {

        AutoGenerator generator = new AutoGenerator();
        // set beetl engine
        generator.setTemplateEngine(new BeetlTemplateEngine());
        generator.setDataSource(getDataSource());
        generator.setGlobalConfig(getGlobal());
        generator.setPackageInfo(getPkgInfo());
        generator.setStrategy(getStrategy(generator.getPackageInfo()));
        generator.execute();


    }

    private static StrategyConfig getStrategy(PackageConfig packageInfo) {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(getIncludes());
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(packageInfo.getModuleName() + "_");

        return strategy;
    }

    private static  String[] getIncludes() {
        List<String> list = new ArrayList<>();
//        list.add("t_soft_data");
//        list.add("t_soft_img");
//        list.add("t_soft_category");
        list.add("R_AUTHOR");
        list.add("R_CATEGORY");
        list.add("r_poems");
        list.add("R_POEMS_YEAR");
        if(CollectionUtils.isEmpty(list)){
            throw new RuntimeException("表列表为空！");
        }
        return list.toArray(new String[list.size()]);
    }

    private static GlobalConfig getGlobal() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/small-dao/src/main/java/");
        globalConfig.setAuthor("siyuan.zhu");
        globalConfig.setOpen(false);
        return globalConfig;
    }

    private static DataSourceConfig getDataSource() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://192.168.179.101:3306/smalldot?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("zp");
        return dataSourceConfig;
    }

    private static PackageConfig getPkgInfo() {
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("");
        pc.setParent("com.smalldot.dao");


        return pc;
    }
}
