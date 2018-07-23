package in.edu.itsecgn.itsengineeringcollege.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.model.BusRoute;

public class BusAdaptor extends RecyclerView.Adapter<BusAdaptor.MyViewHolder> {

    private Context ctx;
    private List<BusRoute> busRoutes;

    public BusAdaptor(Context ctx, List<BusRoute> busRoutes) {
        this.ctx = ctx;
        this.busRoutes = busRoutes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(ctx).inflate(R.layout.item_timeline, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.timingsTextView.setText(busRoutes.get(position).getTimings());
        holder.stopTextView.setText(busRoutes.get(position).getStop());
    }

    @Override
    public int getItemCount() {
        return busRoutes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stopTextView, timingsTextView;


        MyViewHolder(View itemView) {
            super(itemView);
            stopTextView = (TextView) itemView.findViewById(R.id.text_bus_stop);
            timingsTextView = (TextView) itemView.findViewById(R.id.text_bus_time);

        }


    }
}