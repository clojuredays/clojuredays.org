// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.header');
goog.require('cljs.core');
dcd_website.header.header_component = (function dcd_website$header$header_component(var_args){
var args__7522__auto__ = [];
var len__7515__auto___12050 = arguments.length;
var i__7516__auto___12051 = (0);
while(true){
if((i__7516__auto___12051 < len__7515__auto___12050)){
args__7522__auto__.push((arguments[i__7516__auto___12051]));

var G__12052 = (i__7516__auto___12051 + (1));
i__7516__auto___12051 = G__12052;
continue;
} else {
}
break;
}

var argseq__7523__auto__ = ((((1) < args__7522__auto__.length))?(new cljs.core.IndexedSeq(args__7522__auto__.slice((1)),(0))):null);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7523__auto__);
});

dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic = (function (p__12047,children){
var map__12048 = p__12047;
var map__12048__$1 = ((((!((map__12048 == null)))?((((map__12048.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12048.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12048):map__12048);
var styles = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12048__$1,cljs.core.cst$kw$styles);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12048__$1,cljs.core.cst$kw$title);
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header$header,styles,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"img/2018/logo.svg"], null)], null)], null),children], null);
});

dcd_website.header.header_component.cljs$lang$maxFixedArity = (1);

dcd_website.header.header_component.cljs$lang$applyTo = (function (seq12045){
var G__12046 = cljs.core.first(seq12045);
var seq12045__$1 = cljs.core.next(seq12045);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic(G__12046,seq12045__$1);
});
