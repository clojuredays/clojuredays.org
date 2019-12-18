// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.header');
goog.require('cljs.core');
dcd_website.header.header_component = (function dcd_website$header$header_component(var_args){
var args__7531__auto__ = [];
var len__7524__auto___12776 = arguments.length;
var i__7525__auto___12777 = (0);
while(true){
if((i__7525__auto___12777 < len__7524__auto___12776)){
args__7531__auto__.push((arguments[i__7525__auto___12777]));

var G__12778 = (i__7525__auto___12777 + (1));
i__7525__auto___12777 = G__12778;
continue;
} else {
}
break;
}

var argseq__7532__auto__ = ((((1) < args__7531__auto__.length))?(new cljs.core.IndexedSeq(args__7531__auto__.slice((1)),(0))):null);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7532__auto__);
});

dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic = (function (p__12773,children){
var map__12774 = p__12773;
var map__12774__$1 = ((((!((map__12774 == null)))?((((map__12774.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12774.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12774):map__12774);
var styles = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12774__$1,cljs.core.cst$kw$styles);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12774__$1,cljs.core.cst$kw$title);
return new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header$header,styles,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"/img/2019/logo.svg"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$span$title,"DUTCH CLOJURE DAYS 2020"], null),children], null);
});

dcd_website.header.header_component.cljs$lang$maxFixedArity = (1);

dcd_website.header.header_component.cljs$lang$applyTo = (function (seq12771){
var G__12772 = cljs.core.first(seq12771);
var seq12771__$1 = cljs.core.next(seq12771);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic(G__12772,seq12771__$1);
});
