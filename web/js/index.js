
$(function(){
    //轮播图实现开始
    var $carousel_inner=$(".carousel-inner").empty();
    var $indicators=$(".carousel-indicators").empty();
    $.ajax({
        url:"../CarouselServlet",
        data:"method=carouselList&page=1&limit=10",
        dataType:"JSON",
        async:false,
        success:function(res){
            for(var i=0;i<res.data.length;i++){
                var $item_div;
                var $li;
                if(i==0){
                    $item_div=$("<div class='item active'></div>");
                    $li=$("<li data-target='#carousel-example-generic' data-slide-to='"+i+"' class='active'></li>");
                }else{
                    $item_div=$("<div class='item'></div>");
                    $li=$("<li data-target='#carousel-example-generic' data-slide-to='"+i+"'></li>");
                }
                var $container=$("<div class='container'></div>");
                var $h1=$("<h1>"+res.data[i].cardesc+"</h1>");
                var $img=$("<img src='../images/carousel/"+res.data[i].imgpath+"'/>");
                $container.append($h1);
                $container.append($img);
                $item_div.append($container);
                $carousel_inner.append($item_div);
                $indicators.append($li);
            }
        }
    });//轮播图结束
    //首页商品列表开始
    var $goodslist=$(".goodslist").empty();
    $.ajax({
        url:"../GoodsServlet",
        data:"method=goodsListIndex",
        dataType:"JSON",
        async:false,
        success:function(res){
            var $row;
            for(var i=0;i<res.length;i++){
                if(i%3==0){
                    $row=$("<div class='row'></div>");
                }
                var $col=$("<div class='col-sm-6 col-md-4'></div>");
                var $thumbnail=$("<div class='thumbnail'></div>");
                var $img=$("<img src='../images/goods/"+res[i].imgpath+"'/>");
                var $caption=$("<div class='caption'></div>");
                var $h3=$("<h3>"+res[i].name+"</h3>");
                var $p1=$("<p>"+res[i].goodsDesc+"</p>");
                var $p2=$("<p><a href='#' id='addShopCar' title='"+res[i].id+"' class='btn btn-danger' role='button'>添加到购物>></a></p>");
                $caption.append($h3);
                $caption.append($p1);
                $caption.append($p2);
                $thumbnail.append($img);
                $thumbnail.append($caption);
                $col.append($thumbnail);
                $row.append($col);
                if((i+1)%3==0){
                    $goodslist.append($row);
                }
            }
        }
    });
    $.get('../ShopCarServlet','method=carNum',function (res) {
        $(".car-num").text(res);
    },'text')
    $(document).on('click','#addShopCar',function () {
        // alert($(this).attr('title'));
        $.get('../ShopCarServlet','method=saveOrUpdate&'+$(this).attr('title'),function (res) {
            $(".car-num").text(parseInt($(".car-num").text())+1);
        },'text')
    })
});
