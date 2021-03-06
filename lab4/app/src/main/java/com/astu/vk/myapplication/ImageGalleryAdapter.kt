package com.astu.vk.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Korney on 9/29/2017.
 */
class ImageGalleryAdapter: RecyclerView.Adapter<ImageGalleryViewHolder>() {
    val urls = arrayOf(
            "https://cdn4.iconfinder.com/data/icons/48-bubbles/48/30.User-512.png",
            "https://cdn3.iconfinder.com/data/icons/faticons/32/user-01-512.png",
            "https://cdn3.iconfinder.com/data/icons/streamline-icon-set-free-pack/48/Streamline-62-512.png",
            "https://cdn2.iconfinder.com/data/icons/flat-ui-icons-24-px/24/man-24-512.png",
            "https://cdn3.iconfinder.com/data/icons/internet-and-web-4/78/internt_web_technology-13-512.png",
            "https://cdn3.iconfinder.com/data/icons/wpzoom-developer-icon-set/500/88-512.png",
            "https://cdn2.iconfinder.com/data/icons/pittogrammi/142/71-512.png",
            "https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-man-512.png",
            "https://cdn1.iconfinder.com/data/icons/user-pictures/101/malecostume-512.png",
            "https://cdn0.iconfinder.com/data/icons/gcons-2/25/man15-512.png",
            "https://cdn0.iconfinder.com/data/icons/users-android-l-lollipop-icon-pack/24/checked_user-512.png",
            "https://cdn0.iconfinder.com/data/icons/world-issues/500/running_man-512.png",
            "https://cdn1.iconfinder.com/data/icons/user-pictures/100/male3-512.png",
            "https://cdn2.iconfinder.com/data/icons/social-flat-buttons-3/512/anonymous-512.png",
            "https://cdn0.iconfinder.com/data/icons/users-android-l-lollipop-icon-pack/24/worker-512.png",
            "https://cdn1.iconfinder.com/data/icons/unique-round-blue/93/user-512.png",
            "https://cdn1.iconfinder.com/data/icons/round-black-icons-2/78/user-512.png",
            "https://cdn2.iconfinder.com/data/icons/travel-7/520/walking-man-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Man-14-512.png",
            "https://cdn1.iconfinder.com/data/icons/user-pictures/100/supportmale-512.png",
            "https://cdn1.iconfinder.com/data/icons/freeline/32/account_friend_human_man_member_person_profile_user_users-512.png",
            "https://cdn4.iconfinder.com/data/icons/web-development-5/500/developer-api-coding-screen-512.png",
            "https://cdn2.iconfinder.com/data/icons/free-basic-icon-set-2/300/2-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Man-9--512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack/110/Man-1-512.png",
            "https://cdn2.iconfinder.com/data/icons/thesquid-ink-40-free-flat-icon-pack/64/barricade-512.png",
            "https://cdn0.iconfinder.com/data/icons/christmas-icon-set-01/283/gingerbread-man-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack/110/Man-6-512.png",
            "https://cdn2.iconfinder.com/data/icons/travel-7/520/man-512.png",
            "https://cdn0.iconfinder.com/data/icons/flat-round-system/512/android-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack/110/Man-14-512.png",
            "https://cdn4.iconfinder.com/data/icons/christmas-icons/64/christmas-icon-gingerbread-man-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Man-6-512.png",
            "https://cdn4.iconfinder.com/data/icons/ibrandify-basic-essentials-icon-set/512/pen_stroke_sketch_doodle_lineart_47-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Man-1-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack/110/Man-16-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Man-16-512.png",
            "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack/110/Man-9--512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/matureman1-512.png",
            "https://cdn4.iconfinder.com/data/icons/ibrandify-basic-essentials-icon-set/512/pen_stroke_sketch_doodle_lineart_1-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-20-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-12-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/male-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-18-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-03-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-04-512.png",
            "https://cdn1.iconfinder.com/data/icons/avengers-1/512/avangers_icon004-512.png",
            "https://cdn4.iconfinder.com/data/icons/banking-and-finance/500/neck-tie-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/matureman1-2-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-09-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/matureman2-2-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-01-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-25-512.png",
            "https://cdn4.iconfinder.com/data/icons/e-commerce-and-shopping-3/500/sunglasses-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/70/clothing_accesories_clothes_fabric-27-512.png",
            "https://cdn0.iconfinder.com/data/icons/ikooni-outline-free-basic/128/free-17-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/supportmale-2-512.png",
            "https://cdn1.iconfinder.com/data/icons/avengers-1/512/avangers_icon014-512.png",
            "https://cdn1.iconfinder.com/data/icons/dream-icons-2/160/couple-1-512.png",
            "https://cdn2.iconfinder.com/data/icons/clothing-and-accessories-1/80/clothing_accesories_clothes_fabric-02-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/malecostume-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Ironman-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Robin-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Batman-512.png",
            "https://cdn0.iconfinder.com/data/icons/user-pictures/100/matureman2-512.png",
            "https://cdn3.iconfinder.com/data/icons/interface-8/128/InterfaceExpendet-09-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/The_Punisher-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Spiderman-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Flash-512.png",
            "https://cdn0.iconfinder.com/data/icons/superhero-2/256/Superman-512.png",
            "https://cdn3.iconfinder.com/data/icons/i-am-who-i-am/100/2-512.png",
            "https://cdn4.iconfinder.com/data/icons/app-custom-ui-1/48/Account-512.png",
            "https://cdn3.iconfinder.com/data/icons/outline-amenities-icon-set/64/Doorman-512.png",
            "https://cdn3.iconfinder.com/data/icons/metro-contact/512/AIM-512.png",
            "https://cdn2.iconfinder.com/data/icons/bitsies/128/Male-512.png",
            "https://cdn4.iconfinder.com/data/icons/twitter-ui-set/128/Persone-512.png",
            "https://cdn3.iconfinder.com/data/icons/back-to-the-future/512/marty-mcfly-512.png",
            "https://cdn2.iconfinder.com/data/icons/miscellaneous-12/24/miscellaneous-01-512.png",
            "https://cdn2.iconfinder.com/data/icons/miscellaneous-12/24/miscellaneous-02-512.png",
            "https://cdn2.iconfinder.com/data/icons/christmas-46/64/christmas-icon-gingerbread-man-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-15-512.png",
            "https://cdn2.iconfinder.com/data/icons/christmas-hand-drawn-scribbles-icons/512/67-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-13-2-512.png",
            "https://cdn2.iconfinder.com/data/icons/christmas-hand-drawn-scribbles-icons/512/1-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-11-2-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-9-2-512.png",
            "https://cdn2.iconfinder.com/data/icons/christmas-hand-drawn-scribbles-icons/512/65-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-6-2-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-7-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-4-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-8-2-512.png",
            "https://cdn2.iconfinder.com/data/icons/christmas-icons-2016/181/icon-13-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-10-3-512.png",
            "https://cdn3.iconfinder.com/data/icons/user-avatars-1/512/users-2-512.png",
            "https://cdn4.iconfinder.com/data/icons/human-movement/42/19_man_hi_human_talk_communicsation_hanging_1-512.png",
            "https://cdn4.iconfinder.com/data/icons/human-movement/42/12_talk_communication_human_behaviour_male_man-512.png",
            "https://cdn4.iconfinder.com/data/icons/human-movement/42/19_man_hi_human_talk_communicsation_hanging-512.png",
            "https://cdn4.iconfinder.com/data/icons/currency-taiwan-dollar-vol-1/32/man_mind_vision_Coin_currency_dollar_money_price_taiwan_finance-512.png",
            "https://cdn4.iconfinder.com/data/icons/human-movement/42/2_human_behaviour_man_happy_fun_dance_joy_1-512.png",
            "https://cdn4.iconfinder.com/data/icons/currency-guilder-vol-1/32/mind_man_vision_Currency_dutch_guilder_gulden_finance_sign_money-512.png"
    )

    override fun onBindViewHolder(holder: ImageGalleryViewHolder?, position: Int) {
        holder!!.setUrl(urls[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageGalleryViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.image_gallery_card,parent,false);
        return ImageGalleryViewHolder(view,180,180)
    }

    override fun getItemCount(): Int {
        return urls.size
    }
}

