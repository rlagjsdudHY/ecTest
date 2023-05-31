/**
 * 
 */
 
 $(function(){
 	$("#goodsOption").change(function(){
 		//alert("선택 변경됨");
 		let changePrice = $(this).val();
 		let beginIdx = changePrice.indexOf("+") + 1;
 		let endIdx = changePrice.indexOf("원");
 		changePrice = changePrice.substring(beginIdx, endIdx-1);
 		changePrice = changePrice.replace(",", ""); 
 		$("#goodsOptionPrice").val(changePrice);
 	});
 });