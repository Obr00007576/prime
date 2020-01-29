package ru.spbstu.telematics.java.prime;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class primeTest
{
    @Test
    public void prime_check() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(4,1000000);
        for (Integer pr: prime_arr)
        {
            Assert.assertTrue(prime.prime_pool.cal_prime.is_prime(pr));
        }
    }
    @Test
    public void time_test_1() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(1,1000000);
    }
    @Test
    public void time_test_2() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(2,1000000);
    }
    @Test
    public void time_test_3() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(3,1000000);
    }
    @Test
    public void time_test_4() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(4,1000000);
    }
    @Test
    public void time_test_5() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(5,1000000);
    }
    @Test
    public void time_test_6() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(6,1000000);
    }
    @Test
    public void time_test_7() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(7,1000000);
    }
    @Test
    public void time_test_8() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(8,1000000);
    }
    @Test
    public void time_test_9() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(9,1000000);
    }
    @Test
    public void time_test_10() throws ExecutionException, InterruptedException
    {
        prime.prime_pool.init_executor();
        ArrayList<Integer>prime_arr =  prime.prime_pool.Deploy_tasks(10,1000000);
    }
}
