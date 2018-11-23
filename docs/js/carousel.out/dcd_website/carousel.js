// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.carousel');
goog.require('cljs.core');
goog.require('reagent.core');
goog.require('dcd_website.app');
goog.require('dcd_website.dcd2017');
goog.require('dcd_website.header');
goog.require('clojure.string');
dcd_website.carousel.minute_size = (15);
dcd_website.carousel.clean_agenda = (function (){var $ = dcd_website.dcd2017.agenda_data;
var $__$1 = cljs.core.filter.cljs$core$IFn$_invoke$arity$2(((function ($){
return (function (p__12831){
var map__12832 = p__12831;
var map__12832__$1 = ((((!((map__12832 == null)))?((((map__12832.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12832.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12832):map__12832);
var type = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12832__$1,cljs.core.cst$kw$type);
var force_timeline_visible_QMARK_ = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12832__$1,cljs.core.cst$kw$force_DASH_timeline_DASH_visible_QMARK_);
var force_timeline_hidden_QMARK_ = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12832__$1,cljs.core.cst$kw$force_DASH_timeline_DASH_hidden_QMARK_);
var and__6443__auto__ = (function (){var or__6455__auto__ = force_timeline_visible_QMARK_;
if(cljs.core.truth_(or__6455__auto__)){
return or__6455__auto__;
} else {
return new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$lightning,null,cljs.core.cst$kw$talk,null], null), null).call(null,type);
}
})();
if(cljs.core.truth_(and__6443__auto__)){
return cljs.core.not(force_timeline_hidden_QMARK_);
} else {
return and__6443__auto__;
}
});})($))
,$);
return cljs.core.concat.cljs$core$IFn$_invoke$arity$variadic(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$time,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["8:30","9:30"], null),cljs.core.cst$kw$type,cljs.core.cst$kw$org,cljs.core.cst$kw$title,"Reception/Opening"], null)], null),$__$1,cljs.core.array_seq([new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 4, [cljs.core.cst$kw$time,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, ["18:20","20:00"], null),cljs.core.cst$kw$type,cljs.core.cst$kw$org,cljs.core.cst$kw$timeline_DASH_description,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$timeline_DASH_description,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,"Thank you!"], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h3,"See you next year for #DCD18!"], null)], null),cljs.core.cst$kw$title,"Closing/Networking/Drinks"], null)], null)], 0));
})();
dcd_website.carousel.minutes_of_day = (function dcd_website$carousel$minutes_of_day(hh,mm){
return (((60) * hh) + mm);
});
dcd_website.carousel.date__GT_minutes = (function dcd_website$carousel$date__GT_minutes(d){
return dcd_website.carousel.minutes_of_day(d.getHours(),d.getMinutes());
});
dcd_website.carousel.agenda_start = (function (){var start = (function (){var G__12834 = (new Date());
G__12834.setHours((8));

G__12834.setMinutes((30));

return G__12834;
})();
return dcd_website.carousel.date__GT_minutes(start);
})();
/**
 * Calculates the number of minutes since 8:30
 */
dcd_website.carousel.agenda_progress = (function dcd_website$carousel$agenda_progress(date){
var x__6786__auto__ = (0);
var y__6787__auto__ = (dcd_website.carousel.date__GT_minutes(date) - dcd_website.carousel.agenda_start);
return ((x__6786__auto__ > y__6787__auto__) ? x__6786__auto__ : y__6787__auto__);
});
dcd_website.carousel.time_str__GT_minutes = (function dcd_website$carousel$time_str__GT_minutes(s){
var vec__12836 = cljs.core.mapv.cljs$core$IFn$_invoke$arity$2(cljs.core.int$,clojure.string.split.cljs$core$IFn$_invoke$arity$2(s,/:/));
var hh = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12836,(0),null);
var mm = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12836,(1),null);
return dcd_website.carousel.minutes_of_day(hh,mm);
});
dcd_website.carousel.current_progress = (function dcd_website$carousel$current_progress(now){
return new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$progress,dcd_website.carousel.agenda_progress(now)], null);
});
if(typeof dcd_website.carousel.progress !== 'undefined'){
} else {
dcd_website.carousel.progress = reagent.core.atom.cljs$core$IFn$_invoke$arity$1(dcd_website.carousel.current_progress((new Date())));
}
dcd_website.carousel.light_blue = "rgba(160,200,220,.8)";
dcd_website.carousel.lightning_starts_QMARK_ = cljs.core.set(cljs.core.map.cljs$core$IFn$_invoke$arity$2(cljs.core.comp.cljs$core$IFn$_invoke$arity$2(cljs.core.first,cljs.core.cst$kw$time),cljs.core.filter.cljs$core$IFn$_invoke$arity$2(cljs.core.comp.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$lightning,null], null), null),cljs.core.cst$kw$type),dcd_website.carousel.clean_agenda)));
dcd_website.carousel.render_time = (function dcd_website$carousel$render_time(start,fg){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1$time,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$color,fg], null)], null),start], null);
});
dcd_website.carousel.org_slot__GT_width = (function dcd_website$carousel$org_slot__GT_width(start,end,add_padding){
var start_min = dcd_website.carousel.time_str__GT_minutes(start);
var end_min = dcd_website.carousel.time_str__GT_minutes(end);
var padding = (cljs.core.truth_(add_padding)?((10) * dcd_website.carousel.minute_size):(0));
return [cljs.core.str((padding + (dcd_website.carousel.minute_size * (end_min - start_min)))),cljs.core.str("px")].join('');
});
dcd_website.carousel.talk_slot__GT_width = (function dcd_website$carousel$talk_slot__GT_width(start,end,add_padding){
var start_min = dcd_website.carousel.time_str__GT_minutes(start);
var end_min = dcd_website.carousel.time_str__GT_minutes(end);
var padding = (cljs.core.truth_(add_padding)?((10) * dcd_website.carousel.minute_size):(0));
return [cljs.core.str((padding + (dcd_website.carousel.minute_size * (end_min - start_min)))),cljs.core.str("px")].join('');
});
if(typeof dcd_website.carousel.render_slot !== 'undefined'){
} else {
dcd_website.carousel.render_slot = (function (){var method_table__7368__auto__ = (function (){var G__12837 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__12837) : cljs.core.atom.call(null,G__12837));
})();
var prefer_table__7369__auto__ = (function (){var G__12838 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__12838) : cljs.core.atom.call(null,G__12838));
})();
var method_cache__7370__auto__ = (function (){var G__12839 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__12839) : cljs.core.atom.call(null,G__12839));
})();
var cached_hierarchy__7371__auto__ = (function (){var G__12840 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__12840) : cljs.core.atom.call(null,G__12840));
})();
var hierarchy__7372__auto__ = cljs.core.get.cljs$core$IFn$_invoke$arity$3(cljs.core.PersistentArrayMap.EMPTY,cljs.core.cst$kw$hierarchy,cljs.core.get_global_hierarchy());
return (new cljs.core.MultiFn(cljs.core.symbol.cljs$core$IFn$_invoke$arity$2("dcd-website.carousel","render-slot"),((function (method_table__7368__auto__,prefer_table__7369__auto__,method_cache__7370__auto__,cached_hierarchy__7371__auto__,hierarchy__7372__auto__){
return (function (p__12841,_,___$1){
var map__12842 = p__12841;
var map__12842__$1 = ((((!((map__12842 == null)))?((((map__12842.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12842.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12842):map__12842);
var type = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12842__$1,cljs.core.cst$kw$type);
return type;
});})(method_table__7368__auto__,prefer_table__7369__auto__,method_cache__7370__auto__,cached_hierarchy__7371__auto__,hierarchy__7372__auto__))
,cljs.core.cst$kw$default,hierarchy__7372__auto__,method_table__7368__auto__,prefer_table__7369__auto__,method_cache__7370__auto__,cached_hierarchy__7371__auto__));
})();
}
dcd_website.carousel.render_slot.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$org,(function (p__12844,bg,fg){
var map__12845 = p__12844;
var map__12845__$1 = ((((!((map__12845 == null)))?((((map__12845.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12845.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12845):map__12845);
var slot = map__12845__$1;
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12845__$1,cljs.core.cst$kw$title);
var vec__12846 = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12845__$1,cljs.core.cst$kw$time);
var start = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12846,(0),null);
var end = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12846,(1),null);
var author = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12845__$1,cljs.core.cst$kw$author);
var description = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12845__$1,cljs.core.cst$kw$timeline_DASH_description);
var add_padding = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12845__$1,cljs.core.cst$kw$add_DASH_paggind);
var size = dcd_website.carousel.org_slot__GT_width(start,end,add_padding);
return new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$slot,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$min_DASH_height,"100%",cljs.core.cst$kw$min_DASH_width,size,cljs.core.cst$kw$background_DASH_color,bg], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1$title,title], null),(cljs.core.truth_(description)?description:null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.render_time,start,fg], null)], null);
}));
dcd_website.carousel.render_talk_slot = (function dcd_website$carousel$render_talk_slot(p__12848,bg,fg){
var map__12852 = p__12848;
var map__12852__$1 = ((((!((map__12852 == null)))?((((map__12852.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12852.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12852):map__12852);
var slot = map__12852__$1;
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12852__$1,cljs.core.cst$kw$title);
var vec__12853 = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12852__$1,cljs.core.cst$kw$time);
var start = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12853,(0),null);
var end = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12853,(1),null);
var pic = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12852__$1,cljs.core.cst$kw$profile_DASH_pic);
var author = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12852__$1,cljs.core.cst$kw$author);
var add_padding = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12852__$1,cljs.core.cst$kw$add_DASH_padding);
return new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$slot,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$min_DASH_width,dcd_website.carousel.talk_slot__GT_width(start,end,add_padding),cljs.core.cst$kw$background_DASH_color,bg], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1$title,title], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$author,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img$speaker,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,[cljs.core.str("img/speakers/"),cljs.core.str(pic)].join('')], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h3$name,"By ",author], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.render_time,start,fg], null)], null);
});
dcd_website.carousel.render_slot.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$talk,(function (slot,bg,fg){
return dcd_website.carousel.render_talk_slot(slot,bg,fg);
}));
dcd_website.carousel.render_slot.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$lightning,(function (slot,bg,fg){
return dcd_website.carousel.render_talk_slot(slot,bg,fg);
}));
dcd_website.carousel.render_slot.cljs$core$IMultiFn$_add_method$arity$3(null,cljs.core.cst$kw$default,(function (_,___$1,___$2){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h1,"Something went wrong!"], null);
}));
dcd_website.carousel.time_bar = (function dcd_website$carousel$time_bar(){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 6, [cljs.core.cst$kw$position,"fixed",cljs.core.cst$kw$background_DASH_color,"rgba(255, 0, 0, .5)",cljs.core.cst$kw$min_DASH_width,"10px",cljs.core.cst$kw$min_DASH_height,"100%",cljs.core.cst$kw$left,"650px",cljs.core.cst$kw$top,"-100px"], null)], null)], null);
});
dcd_website.carousel.progress__GT_margin = (function dcd_website$carousel$progress__GT_margin(){
if(((0) > cljs.core.cst$kw$progress.cljs$core$IFn$_invoke$arity$1((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(dcd_website.carousel.progress) : cljs.core.deref.call(null,dcd_website.carousel.progress))))){
return "650px";
} else {
return [cljs.core.str(((650) - (dcd_website.carousel.minute_size * cljs.core.cst$kw$progress.cljs$core$IFn$_invoke$arity$1((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(dcd_website.carousel.progress) : cljs.core.deref.call(null,dcd_website.carousel.progress)))))),cljs.core.str("px")].join('');
}
});
dcd_website.carousel.render_all_slots = (function dcd_website$carousel$render_all_slots(slots){
var colors = cljs.core.cycle(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.light_blue,"white"], null));
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 6, [cljs.core.cst$kw$overflow,"hidden",cljs.core.cst$kw$display,"flex",cljs.core.cst$kw$position,"relative",cljs.core.cst$kw$min_DASH_height,"100%",cljs.core.cst$kw$transition,"margin-left 200ms ease-in-out",cljs.core.cst$kw$margin_DASH_left,dcd_website.carousel.progress__GT_margin()], null)], null),cljs.core.doall.cljs$core$IFn$_invoke$arity$1(cljs.core.map.cljs$core$IFn$_invoke$arity$4(((function (colors){
return (function (slot,bg,fg){
return cljs.core.with_meta(new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.render_slot,slot,bg,fg], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,slot], null));
});})(colors))
,slots,colors,cljs.core.drop.cljs$core$IFn$_invoke$arity$2((1),colors)))], null);
});
dcd_website.carousel.carousel_component = (function dcd_website$carousel$carousel_component(){
return new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$site,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$height,"71vh"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.render_all_slots,dcd_website.carousel.clean_agenda], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.time_bar], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$wrapper,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.header.header_component,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 4, [cljs.core.cst$kw$position,"absolute",cljs.core.cst$kw$bottom,(0),cljs.core.cst$kw$height,"350px",cljs.core.cst$kw$width,"100%"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img$all_DASH_sponsors,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"img/all-sponsors.svg"], null)], null)], null)], null);
});
dcd_website.carousel.test_progress = reagent.core.atom.cljs$core$IFn$_invoke$arity$1((8));
dcd_website.carousel.update_progress_test_BANG_ = (function dcd_website$carousel$update_progress_test_BANG_(){
var G__12860_12863 = dcd_website.carousel.progress;
var G__12861_12864 = dcd_website.carousel.current_progress((function (){var G__12862 = (new Date());
G__12862.setHours((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(dcd_website.carousel.test_progress) : cljs.core.deref.call(null,dcd_website.carousel.test_progress)));

G__12862.setMinutes((20));

return G__12862;
})());
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(G__12860_12863,G__12861_12864) : cljs.core.reset_BANG_.call(null,G__12860_12863,G__12861_12864));

cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.carousel.test_progress,cljs.core.inc);

return true;
});
dcd_website.carousel.update_progress_BANG_ = (function dcd_website$carousel$update_progress_BANG_(){
var d = (new Date());
if((d.getHours() < (19))){
var G__12871_12877 = dcd_website.carousel.progress;
var G__12872_12878 = dcd_website.carousel.current_progress(d);
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(G__12871_12877,G__12872_12878) : cljs.core.reset_BANG_.call(null,G__12871_12877,G__12872_12878));

return true;
} else {
var G__12874_12879 = dcd_website.carousel.progress;
var G__12875_12880 = dcd_website.carousel.current_progress((function (){var G__12876 = d;
G__12876.setHours((19));

G__12876.setMinutes((20));

return G__12876;
})());
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(G__12874_12879,G__12875_12880) : cljs.core.reset_BANG_.call(null,G__12874_12879,G__12875_12880));

return false;
}
});
dcd_website.carousel.set_time_test = (function dcd_website$carousel$set_time_test(hh,mm){
var G__12886 = dcd_website.carousel.progress;
var G__12887 = dcd_website.carousel.current_progress((function (){var G__12888 = (new Date());
G__12888.setHours(hh);

G__12888.setMinutes(mm);

return G__12888;
})());
return (cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(G__12886,G__12887) : cljs.core.reset_BANG_.call(null,G__12886,G__12887));
});
dcd_website.carousel.schedule = (function dcd_website$carousel$schedule(f,t){
return window.setTimeout((function (){
if(cljs.core.truth_((f.cljs$core$IFn$_invoke$arity$0 ? f.cljs$core$IFn$_invoke$arity$0() : f.call(null)))){
return dcd_website$carousel$schedule(f,t);
} else {
return null;
}
}),t);
});
dcd_website.carousel.init = (function dcd_website$carousel$init(){
dcd_website.app.init();

if(cljs.core.truth_(document.location)){
var root = document.getElementById("carousel-container");
if(cljs.core.truth_(root)){
var G__12891_12893 = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.carousel.carousel_component], null);
var G__12892_12894 = root;
(reagent.core.render_component.cljs$core$IFn$_invoke$arity$2 ? reagent.core.render_component.cljs$core$IFn$_invoke$arity$2(G__12891_12893,G__12892_12894) : reagent.core.render_component.call(null,G__12891_12893,G__12892_12894));

return dcd_website.carousel.schedule(dcd_website.carousel.update_progress_BANG_,(1000));
} else {
return null;
}
} else {
return null;
}
});
