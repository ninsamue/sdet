select salesman_id,max(purchase_amount) as "Highest Purchase" from orders group by salesman_id;

select salesman_id,order_Date,max(purchase_amount) as "Highest Purchase" from orders where order_Date =To_DATE('2012/08/17', 'YYYY/MM/DD') group by salesman_id,order_Date;

select customer_id,order_Date,max(purchase_amount) as "Highest Purchase" from orders group by customer_id,order_Date having max(purchase_amount) in (2030, 3450, 5760, 6000);