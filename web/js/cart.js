/*
webpackJsonp([0],[
/!* 0 *!/
/!***!/ (function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__(1);


/!***!/ }),
/!* 1 *!/
/!***!/ (function(module, exports, __webpack_require__) {



	'use strict';
	__webpack_require__(2);
	__webpack_require__(7);
	__webpack_require__(16);
	var page = {
	    init : function(){
	        this.bindEvent1();
	    },
	    bindEvent1:function(){
	         // 提交购物车
	        $(document).on('click','.submit-btn',function(){
	            window.location.href = './order-confirm.html';
	        });
	    }
	};
	$(function(){
	    page.init();
	})


/!***!/ }),
/!* 2 *!/
/!***!/ (function(module, exports) {

	// removed by extract-text-webpack-plugin

/!***!/ })
]);*/
var deleteGoods = null
$.get('../../ShopCarServlet','method=shopCarList',function (res) {
    loadGoods(res);
},'JSON');
function loadGoods(goodsList) {
    $.each(goodsList, function(i, item) {
        var goodsHtml = '<tr class="goods-item"> ' +
            '                            <td class="cart-cell cell-check">  ' +
            '                                <input type="checkbox" class="cart-select">   ' +
            '                            </td> ' +
            '                            <td class="cart-cell cell-img"> ' +
            '                                <a href="./detail.html?productId=107" target="_blank">' +
            '                                    <img class="p-img" src="../images/goods/'+item.imgpach+'">' +
            '                                </a> ' +
            '                            </td> ' +
            '                            <td class="cart-cell cell-info"> ' +
            '                                <a class="link p-name" href="./detail.html?productId=107" target="_blank">'+item.name +'</a>' +
            '                            </td> ' +
            '                            <td class="cart-cell cell-price"><span>￥</span><span class="single-price">' + toDecimal2(item.price) + '</span></td> ' +
            '                            <td class="cart-cell cell-count"> ' +
            '                                <span class="count-btn car-decrease" data-opera-type="minus">-</span>' +
            '                                <input class="count-input goods-count" data-max="9987" value="' + item.num + '">' +
            '                                <span class="count-btn car-add" data-opera-type="plus">+</span>' +
            '                            </td> ' +
            '                            <td class="cart-cell cell-total"><span>￥</span><span class="single-total">' + toDecimal2(item.price*item.num) + '</span></td> ' +
            '                            <td class="cart-cell cell-opera"> ' +
            '                                <a class="link cart-delete">删除</a> ' +
            '                            </td> ' +
            '                        </tr> '
        $('.cart-list tbody').append(goodsHtml)
    })
}

function ShoppingCarObserver(elInput, isAdd) {
    this.elInput = elInput
    this.parents = this.elInput.parents('.goods-item')
    this.count = parseInt(this.elInput.val())
    this.isAdd = isAdd
    this.singlePrice = parseFloat(this.parents.find('.single-price').text())
    this.computeGoodsMoney = function() {
        var moneyCount = toDecimal2(this.count * this.singlePrice)
        var singleTotalEl = this.parents.find('.single-total')
        // console.log(moneyCount)
        singleTotalEl.empty().append(moneyCount)
    }
    this.showCount = function() {
        var isChecked = this.parents.find('.cart-select')[0].checked
        var GoodsTotalMoney = parseFloat($('#selectGoodsMoney').text())
        var goodsTotalCount = parseInt($('#selectGoodsCount').text())
        if(this.elInput) {
            if(this.isAdd) {
                ++this.count
                if(isChecked) {
                    $('#selectGoodsMoney').empty().append(toDecimal2(GoodsTotalMoney + this.singlePrice))
                    $('#selectGoodsCount').empty().append(goodsTotalCount + 1)
                }
            } else {
                if(parseInt(this.count) <= 1) {
                    return
                } else {
                    --this.count
                    if(isChecked) {
                        $('#selectGoodsMoney').empty().append(toDecimal2(GoodsTotalMoney - this.singlePrice))
                        $('#selectGoodsCount').empty().append(goodsTotalCount - 1)
                    }
                }
            }
            this.elInput.val(this.count)
        }
    }
    this.checkIsAll = function() {
        var checkLen = $('.cart-select:checked').length
        if (checkLen > 0) {
            $('.submit-con .btn').removeClass('submitDis')
        } else {
            $('.submit-con .btn').addClass('submitDis')
        }
        if($('.goods-item').length === checkLen) {
            $('.cart-select-all').prop('checked', true)
        } else {
            $('.cart-select-all').prop('checked', false)
        }
    }
    this.checkedChange = function(isChecked) {
        if(isChecked === undefined) {
            var isChecked = this.parents.find('.cart-select')[0].checked
        }
        var itemTotalMoney = parseFloat(this.parents.find('.single-total').text())
        var GoodsTotalMoney = parseFloat($('#selectGoodsMoney').text())
        var itemCount = parseInt(this.parents.find('.goods-count').val())
        var goodsTotalCount = parseInt($('#selectGoodsCount').text())
        if(isChecked) {
            $('#selectGoodsMoney').empty().append(toDecimal2(itemTotalMoney + GoodsTotalMoney))
            $('#selectGoodsCount').empty().append(itemCount + goodsTotalCount)
        } else {
            if (GoodsTotalMoney - itemTotalMoney === 0) {
                $('#selectGoodsMoney').empty().append('0.00')
                if (!$('.submit-con .btn').hasClass('submitDis')) {
                    $('.submit-con .btn').addClass('submitDis')
                }
            } else {
                $('#selectGoodsMoney').empty().append(toDecimal2(GoodsTotalMoney - itemTotalMoney))
            }
            $('#selectGoodsCount').empty().append(goodsTotalCount - itemCount)
        }
    }
    this.deleteGoods = function() {
        var isChecked = this.parents.find('.cart-select')[0].checked
        if(isChecked) {
            this.checkedChange(false)
        }
        this.parents.remove()
        this.checkOptions()
    }
    this.checkOptions = function() {
        if ($('.cart-select-all')[0].checked) {
            if ($('.cart-select').length <= 0) {
                $('.cart-select-all').prop('checked', false)
            }
        }
    }
}
function checkedAll(_this) {
    if ($('.goods-item').length <= 0) {
        $('.submit-con .btn').addClass('submitDis')
    } else {
        $('.submit-con .btn').removeClass('submitDis')
    }
    for(var i = 0; i < $('.goods-item').length; i++) {
        var elInput = $('.goods-item').eq(i).find('.cart-select')
        var isChecked = $('.goods-item').eq(i).find('.cart-select')[0].checked
        var checkAllEvent = new ShoppingCarObserver(elInput, null)
        if(_this.checked) {
            if(!isChecked) {
                elInput.prop('checked', true)
                checkAllEvent.checkedChange(true)
            }
        } else {
            if (!$('.submit-con .btn').hasClass('submitDis')){
                $('.submit-con .btn').addClass('submitDis')
            }
            if(isChecked) {
                elInput.prop('checked', false)
                checkAllEvent.checkedChange(false)
            }
        }
    }
}
$('.cart-select-all').on('change', function() {
    if(this.checked) {
        $('#checked-all-bottom').prop('checked', true)
    } else {
        $('#checked-all-bottom').prop('checked', false)
    }
    checkedAll(this)
})
$('.cart-select').on('change', function() {
    var tmpCheckEl = $(this)
    var checkEvent = new ShoppingCarObserver(tmpCheckEl, null)
    checkEvent.checkedChange()
    checkEvent.checkIsAll()
})
$('.cart-list tbody').on('click', '.car-decrease', function() {
    var goodsInput = $(this).parents('.cell-count').find('.goods-count')
    var decreaseCount = new ShoppingCarObserver(goodsInput, false)
    decreaseCount.showCount()
    decreaseCount.computeGoodsMoney()
})
$('.cart-list tbody').on('click', '.car-add', function() {
    var goodsInput = $(this).parents('.cell-count').find('.goods-count')
    var addCount = new ShoppingCarObserver(goodsInput, true)
    addCount.showCount()
    addCount.computeGoodsMoney()
})
$('.cart-list tbody').on('click', '.cart-delete', function() {
    var goodsInput = $(this).parents('.goods-item').find('.cart-select')
    deleteGoods = new ShoppingCarObserver(goodsInput, null)
    if(deleteGoods !== null) {
        deleteGoods.deleteGoods()
    }
})

$(document).on('click','.cart-delete', function() {
    if($('.cart-select:checked').length > 0) {
        for (var i = 0; i < $('.cart-select:checked').length; i++) {
            var multyDelete = new ShoppingCarObserver($('.cart-select:checked').eq(i), null)
            multyDelete.deleteGoods()
            i--
        }
        multyDelete.checkOptions()
    }
})
