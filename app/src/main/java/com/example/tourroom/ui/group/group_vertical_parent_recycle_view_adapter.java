package com.example.tourroom.ui.group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourroom.R;
import com.google.android.material.card.MaterialCardView;

public class group_vertical_parent_recycle_view_adapter extends RecyclerView.Adapter implements HRecyclerViewClickInterface {

public VRecyclerViewClickInterface vRecyclerViewClickInterface;


    public group_vertical_parent_recycle_view_adapter(VRecyclerViewClickInterface vRecyclerViewClickInterface) {
        this.vRecyclerViewClickInterface = vRecyclerViewClickInterface;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return 0;
        }else if (position == 1){
            return 1;
        }
        return 2;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if(viewType == 0){
            view = layoutInflater.inflate(R.layout.group_vertical_parent_recycle_view_row_0,parent,false);
            return new row_0_view_holder(view);
        }else if(viewType == 1){
            view = layoutInflater.inflate(R.layout.group_vertical_parent_recycle_view_row_1,parent,false);
            return new row_1_view_holder(view);
        }
        view = layoutInflater.inflate(R.layout.group_vertical_parent_recycle_view_row_2,parent,false);
        return new row_2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) { //child add
        if (position == 1){

            RecyclerAdapterForHorizontalScroll recyclerAdapterForHorizontalScroll = new RecyclerAdapterForHorizontalScroll(this);
            row_1_view_holder row_1_view_holder = (group_vertical_parent_recycle_view_adapter.row_1_view_holder) holder;
            row_1_view_holder.horizontal_child_recycle_view.setAdapter(recyclerAdapterForHorizontalScroll);

        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onItemClickH(int position) {
        vRecyclerViewClickInterface.groupinfoonclick(position);
    }

    class row_0_view_holder extends RecyclerView.ViewHolder{

        TextView add_new_group_text_view;
        ImageView imageView_foraddingnewgroup;

        public row_0_view_holder(@NonNull View itemView) {
            super(itemView);
            add_new_group_text_view = itemView.findViewById(R.id.createnewgroup_textView);
            imageView_foraddingnewgroup = itemView.findViewById(R.id.addgroupimagebutton);

            imageView_foraddingnewgroup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               vRecyclerViewClickInterface.creategrouponclick();
           }
       });

        }
    }

    class row_1_view_holder extends RecyclerView.ViewHolder{

        TextView recommend_group_text_view, tour_group_text_view;
        RecyclerView horizontal_child_recycle_view;

        public row_1_view_holder(@NonNull View itemView) {
            super(itemView);
            recommend_group_text_view = itemView.findViewById(R.id.recommendedgrouptextview);
            tour_group_text_view = itemView.findViewById(R.id.yourgrouptextview);
            horizontal_child_recycle_view = itemView.findViewById(R.id.group_child_horizontal_recycle_view_id);
        }
    }

    class row_2_view_holder extends RecyclerView.ViewHolder{

        ImageView vertical_recycle_view_place_image;
        TextView vertical_recycle_view_place_name;
        MaterialCardView group_vertical_parent_recycle_view_row_card;



        public row_2_view_holder(@NonNull View itemView) {
            super(itemView);
            vertical_recycle_view_place_image = itemView.findViewById(R.id.owngroupimageview);
            vertical_recycle_view_place_name = itemView.findViewById(R.id.owngroupnametextview);
            group_vertical_parent_recycle_view_row_card = itemView.findViewById(R.id.group_vertical_parent_recycle_view_row_card_id);

            group_vertical_parent_recycle_view_row_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      vRecyclerViewClickInterface.onItemClickV(getAdapterPosition());
                }
            });
        }
    }

}


