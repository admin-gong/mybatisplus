package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.mapper.UserMapper;
import com.example.mybatisplusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusdemoApplicationTests {
@Autowired
private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
@Test
    public void insertTest(){
        User user = new User();
        user.setId(6124222222224L);
        user.setName("1223132");
        user.setAge(18);
        user.setEmail("wwww.cadada");


        userMapper.insert(user);
        
    }
    @Test
    public void uodateTest(){
        User user = new User();
        user.setName("123456");
        user.setId(2L);

        userMapper.updateById(user);


    }

    //测试乐观锁
    @Test
    public void TestOpt(){
        //查询用户信息
        User user = userMapper.selectById(1L);
        user.setName("kuansghen");
        user.setEmail("1234556");

        User user2 = userMapper.selectById(1L);
        user.setName("kuansghen111");
        user.setEmail("12345561111");
        userMapper.updateById(user2);
        //执行更新操作
        //
        userMapper.updateById(user);

    }
    @Test
    public void Testselete(){
        //查询用户信息
        User user = userMapper.selectById(1L);
    }

    @Test
    public void TestSelectBatchById(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

    }
    
    @Test
    public void PageTest(){
        //当前页
        //页面大小
        Page<User> userPage = new Page<>(1,5);
        userMapper.selectPage(userPage,null);
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){

        userMapper.deleteById(1L);
    }


    //wrapper 条件查询测试
    @Test
    public void wrapperTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(queryWrapper);

    }

}
