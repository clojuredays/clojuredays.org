// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.agenda');
goog.require('cljs.core');
goog.require('dcd_website.style');
dcd_website.agenda.table_row = (function dcd_website$agenda$table_row(p__12795){
var map__12799 = p__12795;
var map__12799__$1 = ((((!((map__12799 == null)))?((((map__12799.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12799.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12799):map__12799);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12799__$1,cljs.core.cst$kw$title);
var time = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12799__$1,cljs.core.cst$kw$time);
var author = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12799__$1,cljs.core.cst$kw$author);
var type = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12799__$1,cljs.core.cst$kw$type);
var vec__12801 = time;
var start = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12801,(0),null);
var end = cljs.core.nth.cljs$core$IFn$_invoke$arity$3(vec__12801,(1),null);
return cljs.core.with_meta(new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$tr,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$style,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$background,(dcd_website.style.colors.cljs$core$IFn$_invoke$arity$1 ? dcd_website.style.colors.cljs$core$IFn$_invoke$arity$1(type) : dcd_website.style.colors.call(null,type))], null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$td$time,(cljs.core.truth_(start)?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$p$start,start], null):null),(cljs.core.truth_(end)?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$p$end,end], null):null)], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$td,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$col_DASH_span,(cljs.core.truth_(author)?(1):(2))], null),title], null),(cljs.core.truth_(author)?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$td,author], null):null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,[cljs.core.str(time),cljs.core.str(author)].join('')], null));
});
dcd_website.agenda.agenda_component = (function dcd_website$agenda$agenda_component(agenda_data){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$agenda,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$table,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$cell_DASH_spacing,(0)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$tbody,cljs.core.doall.cljs$core$IFn$_invoke$arity$1(cljs.core.map.cljs$core$IFn$_invoke$arity$2(dcd_website.agenda.table_row,agenda_data))], null)], null)], null);
});
dcd_website.agenda.speaker_component = (function dcd_website$agenda$speaker_component(p__12802){
var map__12805 = p__12802;
var map__12805__$1 = ((((!((map__12805 == null)))?((((map__12805.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12805.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12805):map__12805);
var author = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$author);
var description = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$description);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$title);
var type = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$type);
var profile_pic = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$profile_DASH_pic);
var bio = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$bio);
var twitter = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$twitter);
var youtube_link = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12805__$1,cljs.core.cst$kw$youtube_DASH_link);
return cljs.core.with_meta(new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$speaker,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$name,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,[cljs.core.str("img/speakers/"),cljs.core.str(profile_pic)].join('')], null)], null),(cljs.core.truth_(twitter)?new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$twitter_DASH_link,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,[cljs.core.str("https://twitter.com/"),cljs.core.str(twitter)].join(''),cljs.core.cst$kw$target,cljs.core.cst$kw$_blank], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img$icon$twitter,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"img/icons/twitter.svg"], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$span$twitter_DASH_handle,[cljs.core.str("@"),cljs.core.str(twitter)].join('')], null)], null):null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h3,author], null)], null),new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$info,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h3$title,((cljs.core._EQ_.cljs$core$IFn$_invoke$arity$2(cljs.core.cst$kw$lightning,type))?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$span$lightning,"lightning talk"], null):null),title], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$description,description], null),(cljs.core.truth_(bio)?new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$bio,"About the speaker: ",bio], null):null),(cljs.core.truth_(youtube_link)?new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$youtube_DASH_link,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,youtube_link,cljs.core.cst$kw$target,cljs.core.cst$kw$_blank], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img$icon$youtube,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"img/icons/youtube.svg"], null)], null),"Watch on YouTube"], null):null)], null)], null),new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$key,author], null));
});
dcd_website.agenda.speakers_component = (function dcd_website$agenda$speakers_component(agenda_data){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$speakers,cljs.core.doall.cljs$core$IFn$_invoke$arity$1(cljs.core.map.cljs$core$IFn$_invoke$arity$2(dcd_website.agenda.speaker_component,cljs.core.filter.cljs$core$IFn$_invoke$arity$2((function (p1__12807_SHARP_){
var and__6445__auto__ = cljs.core.cst$kw$profile_DASH_pic.cljs$core$IFn$_invoke$arity$1(p1__12807_SHARP_);
if(cljs.core.truth_(and__6445__auto__)){
return new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$lightning,null,cljs.core.cst$kw$talk,null], null), null).call(null,cljs.core.cst$kw$type.cljs$core$IFn$_invoke$arity$1(p1__12807_SHARP_));
} else {
return and__6445__auto__;
}
}),agenda_data)))], null);
});
