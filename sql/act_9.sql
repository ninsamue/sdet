select t1.SALESMAN_ID,t1.SALESMAN_NAME,t1.SALESMAN_CITY,t2.CUSTOMER_NAME,t2.CITY from 
salesman t1 inner join customers t2
on t1.salesman_id = t2.salesman_id;

select t1.CUSTOMER_ID,t1.CUSTOMER_NAME,t1.GRADE,t2.SALESMAN_NAME from  
customers t1 left outer join salesman t2
on t1.salesman_id = t2.salesman_id;
where t1.GRADE<300 order by t1.CUSTOMER_ID asc;

select t1.CUSTOMER_ID,t1.CUSTOMER_NAME,t2.SALESMAN_NAME,t2.COMMISSION from
customers t1 inner join salesman t2
on t1.salesman_id = t2.salesman_id;
where t2.commission>12;

select t1.*,t2.customer_name,t3.salesman_name,t3.commission from 
orders t1 inner join customers t2
on t1.CUSTOMER_ID= t2.CUSTOMER_ID
inner join salesman t3
on t2.salesman_id=t3.salesman_id;