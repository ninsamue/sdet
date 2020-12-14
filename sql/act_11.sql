select customer_id, customer_name from customers t1
where 1<(select count(*) from orders t2 where t1.customer_id = t2.customer_id)
union
select salesman_id, salesman_name from salesman t1
where 1<(select count(*) from orders t2 where t1.salesman_id = t2.salesman_id)
order by customer_name;


select t1.salesman_id, salesman_name, order_no, 'highest on', order_date from salesman t1, orders t2
where t1.salesman_id=t2.salesman_id
and t2.purchase_amount=(select max(purchase_amount) from orders t3 where t3.order_date = t2.order_date)
union
select t1.salesman_id, salesman_name, order_no, 'lowest on', order_date from salesman t1, orders t2
where t1.salesman_id=t2.salesman_id
and t2.purchase_amount=(select min(purchase_amount) from orders t3 where t3.order_date = t2.order_date);
