var goodsList = [{
		id: 1234564876,
		imgUrl: 'img/2018110101.jpg',
		goodsInfo: '号地块健身房回复的科技示范户快速坚实的看了看大家发快递了很费劲的开始放假',
		goodsParams: '四季度后付款的酸辣粉',
		price: 199,
		goodsCount: 1,
		singleGoodsMoney: 199
	},
	{
		id: 1234564876,
		imgUrl: 'img/2018110102.jpg',
		goodsInfo: '号地块健身房回复的科技示范户快速坚实的看了看大家发快递了很费劲的开始放假',
		goodsParams: '四季度后付款的酸辣粉',
		price: 299,
		goodsCount: 2,
		singleGoodsMoney: 598
	},
	{
		id: 1234564876,
		imgUrl: 'img/2018110103.jpg',
		goodsInfo: '号地块健身房回复的科技示范户快速坚实的看了看大家发快递了很费劲的开始放假',
		goodsParams: '四季度后付款的酸辣粉',
		price: 399,
		goodsCount: 1,
		singleGoodsMoney: 399
	}
]
var deleteGoods = null
loadGoods()

function loadGoods() {
	$.each(goodsList, function(i, item) {
		var goodsHtml = '<tr>'+
                +'<td>'+ 
                +'    <div class="c_s_img"><img src="'+item.imgUrl+'" width="73" height="73" /></div>'+ 
                +goodsInfo+ 
                +'</td> '+ 
                +'<td align="center">'+item.goodsCount+'</td>'+ 
                +'<td align="center" style="color:#ff4e00;">￥620.00</td>'+ 
                +'<td align="center">26R</td>'+ 
                +'</tr>'
		$('.goods-content').append(goodsHtml)
	})
}
