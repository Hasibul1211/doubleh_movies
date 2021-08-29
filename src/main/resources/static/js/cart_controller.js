$(document).ready(function () {
    $(".minusButton").on("click",function (evt) {
        evt.preventDefault();
        decreaseQuantity($(this));
    });



    $(".plusButton").on("click",function (evt) {
        evt.preventDefault();
        increaseQuantity($(this));

    });
    updateTotal();
});
function increaseQuantity(link) {
    fid = link.attr("fid");
    cid = link.attr("cid");
    qtyValue = $("#quantity"+fid);

    newQty = parseInt(qtyValue.val()) + 1;
    if(newQty < 10){
        qtyValue.val(newQty);

        // var newValue=parseInt($(obj).parent().siblings("input").val())+1;
        // $(obj).parent().siblings("input").val(newValue);

    updateQuantity(newQty,fid,cid);
    }
}
function decreaseQuantity(link) {
    fid = link.attr("fid");
    qtyValue = $("#quantity"+fid);
    cid = link.attr("cid");
    newQty = parseInt(qtyValue.val()) - 1;
    if(newQty > 0){
        qtyValue.val(newQty);
        updateQuantity(newQty,fid,cid);
    }
}


function updateQuantity(quantity,fid,cid) {
     // ctxPath = [[${#servletContext.contextPath}]];
     // customer_id = [[${session.customer.customer_id}]];
    $("#qa").load("http://localhost:8080/doubleh_movies/quantity?cid="+cid+"&fid="+fid+"&quantity="+quantity);
    // window.location="http://localhost:8080/doubleh_movies/quantity?cid="+cid+"&fid="+fid+"&quantity="+quantity;
}
function updateTotal() {
    total = 0.0;
    $(".movieSubtotal").each(function (index,element) {

        total = total + parseFloat(element.innerHTML);

    });

$("#totalAmount").text(total.toFixed(2));
}