(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-17660056"],{"41dd":function(t,e,n){"use strict";var a=n("d225"),c=n("b0b4"),r=n("bc3a"),i=n.n(r),o="/api/v1/category",s=function(){function t(){Object(a["a"])(this,t)}return Object(c["a"])(t,[{key:"retrieveAllCategories",value:function(){return i.a.get("".concat(o))}},{key:"retrieveCategory",value:function(t){return i.a.get("".concat(o,"/").concat(t))}},{key:"deleteCategory",value:function(t){return i.a.delete("".concat(o,"/").concat(t))}},{key:"updateCategory",value:function(t,e){return i.a.put("".concat(o,"/").concat(t),e)}},{key:"createCategory",value:function(t){return console.log(t),i.a.post("".concat(o),t)}}]),t}();e["a"]=new s},bafc:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"container"},[n("h3",[t._v(" 품목 관리 화면 ")]),t.message?n("div",{staticClass:"alert alert-success"},[t._v("\n    "+t._s(this.message))]):t._e(),n("div",{staticClass:"row"},[n("button",{staticClass:"btn btn-success",on:{click:function(e){return t.addCtg()}}},[t._v("Add")])]),n("div",{staticClass:"container"},[n("table",{staticClass:"table"},[t._m(0),n("tbody",t._l(t.categories,(function(e){return n("tr",{key:e.id},[n("td",[t._v(t._s(e.id))]),n("td",[t._v(t._s(e.categoryName))]),n("td",[t._v(t._s(e.targetInfo))]),n("td",[n("button",{staticClass:"btn btn-warning",on:{click:function(n){return t.updateCtg(e.id)}}},[t._v("\n              Update\n            ")])]),n("td",[n("button",{staticClass:"btn btn-danger",on:{click:function(n){return t.deleteCtg(e.id)}}},[t._v("\n              Delete\n            ")])])])})),0)])])])},c=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("thead",[n("tr",[n("th",[t._v(" idx ")]),n("th",[t._v(" 품목명 ")]),n("th",[t._v(" 관리 사이트 항목 ")]),n("th",[t._v(" 수정 ")]),n("th",[t._v(" 삭제 ")])])])}],r=n("41dd"),i=(n("ed77"),{name:"Categories",data:function(){return{categories:[],message:"",priceInfo:[]}},mounted:function(){},methods:{refreshCategories:function(){var t=this;r["a"].retrieveAllCategories().then((function(e){t.categories=e.data}))},addCtg:function(){this.$router.push("/category/-1")},updateCtg:function(t){this.$router.push("/category/".concat(t))},deleteCtg:function(t){var e=this;r["a"].deleteCategory(t).then((function(){e.refreshCategories()}))}},created:function(){this.refreshCategories()}}),o=i,s=n("2877"),u=Object(s["a"])(o,a,c,!1,null,null,null);e["default"]=u.exports},ed77:function(t,e,n){"use strict";var a=n("d225"),c=n("b0b4"),r=n("bc3a"),i=n.n(r),o="/api/v1/price",s=function(){function t(){Object(a["a"])(this,t)}return Object(c["a"])(t,[{key:"retrieveAllPrices",value:function(){return i.a.get("".concat(o))}},{key:"retrievePriceByCompNameAndItemName",value:function(t,e){return i.a.get("".concat(o,"?source=").concat(t,"&item=").concat(e))}}]),t}();e["a"]=new s}}]);
//# sourceMappingURL=chunk-17660056.1d091057.js.map