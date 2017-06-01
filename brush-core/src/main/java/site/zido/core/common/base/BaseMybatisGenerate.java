package site.zido.core.common.base;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis代码构造生成器
 * <p>
 * 继承此方法，编写main函数，调用start方法即可生成构造函数 </br>
 * 重写config前缀的函数，实现自定义
 * </p>
 *
 * @author zido
 * @since 2017/5/25
 */
public abstract class BaseMybatisGenerate {
    /**
     * 全局配置，包括生成路径等
     *
     * @param gc 全局配置
     */
    public void configGlobal(GlobalConfig gc) {

    }

    /**
     * 数据源配置，默认配置为项目开发数据源
     *
     * @param dsc 数据源配置
     */
    public void configDataSource(DataSourceConfig dsc) {

    }

    /**
     * 命名策略配置 ，默认驼峰命名，不建议更改
     *
     * @param sc 命名配置
     */
    public void configStrategy(StrategyConfig sc) {

    }

    /**
     * 包名配置,默认为项目包名,根据实际情况进行修改
     *
     * @param pc 包名配置
     */
    public void configPackage(PackageConfig pc) {

    }

    /**
     * 执行
     */
    private void execute() {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("zido");
        configGlobal(gc);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://192.168.0.103:3306/dc_brush?characterEncoding=utf8");
        configDataSource(dsc);
        mpg.setDataSource(dsc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"brush_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        configStrategy(strategy);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("site");
        pc.setModuleName("zido");
        configPackage(pc);
        mpg.setPackageInfo(pc);
        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);
        mpg.setTemplate(tc);
        mpg.execute();
        System.err.println("执行完成");
    }

    protected static void start(Class<? extends BaseMybatisGenerate> classzz) {
        BaseMybatisGenerate generator = null;
        try {
            generator = classzz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (generator == null) {
            System.err.println("执行失败");
            return;
        }
        generator.execute();
    }
}
