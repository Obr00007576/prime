package ru.spbstu.telematics.java.prime;
import org.apache.commons.math3.optim.InitialGuess;

import java.util.ArrayList;
import java.util.concurrent.*;

public class prime {
    public static class prime_pool
    {
        private static ExecutorService executor;
        public static void init_executor()
        {
            executor = Executors.newFixedThreadPool(10);
        }
        public static Future<ArrayList<Integer>> get_task(Integer a, Integer b)
        {
            return executor.submit(new cal_prime(a,b));
        }
        public static void stop()
        {
            executor.shutdown();
        }
        public static ArrayList<Integer> Deploy_tasks(Integer num_task, Integer bound) throws ExecutionException, InterruptedException
        {
            ArrayList<Future<ArrayList<Integer>>> future_arr=new ArrayList<Future<ArrayList<Integer>>>();
            ArrayList<Integer>prime_arr=new ArrayList<Integer>();
            Integer k;
            k=(bound-1)/num_task;
            Integer m=2;
            int d=(bound-1)%num_task;
            for(int i=0;i<num_task;i++)
            {
                if(d>0)
                {
                    Future<ArrayList<Integer>> future = get_task(m, m + k);
                    future_arr.add(future);
                    m=m+k+1;
                }
                else
                {
                    Future<ArrayList<Integer>> future = get_task(m, m+k-1);
                    future_arr.add(future);
                    m=m+k;
                }
                d-=1;
            }
            while(true)
            {
                if(is_all_completed(future_arr))
                {
                    executor.shutdown();
                    break;
                }
            }
            for (Future<ArrayList<Integer>> future: future_arr)
            {
                prime_arr.addAll(future.get());
            }
            return prime_arr;
        }
        private static boolean is_all_completed(ArrayList<Future<ArrayList<Integer>>> future_arr)
        {
            for (Future<ArrayList<Integer>> future: future_arr)
            {
                if(!future.isDone())
                {
                    return false;
                }
            }
            return true;
        }
        public static class cal_prime implements Callable< ArrayList<Integer>>
        {
            private Integer a,b;
            cal_prime(Integer a, Integer b)
            {
                this.a=a;
                this.b=b;
            }
            public static boolean is_prime(Integer n)
            {
                for(int i=2;i*i<=n;i++)
                {
                    if (n % i == 0) return false;
                }
                return true;
            }
            ArrayList<Integer> get_prime(Integer a, Integer b)
            {
                ArrayList<Integer> prime_arr = new ArrayList<Integer>();
                for(int i=a;i<=b;i++)
                {
                    if(is_prime(i))
                    {
                        prime_arr.add(i);
                    }
                }
                return prime_arr;
            }
            @Override
            public ArrayList<Integer> call() throws Exception {
                return get_prime(this.a,this.b);
            }
        }
    }
}
