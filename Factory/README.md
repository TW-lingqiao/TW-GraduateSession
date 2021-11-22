#Suggestion:

## AbstractFactory为什么要将以下两个方法暴露出来？：
Phone makePhone();

PC makePC();

produce方法最终调用的是 makePhone 和 makePC，那为什么这两个方法要放到接口中，暴露给用户？