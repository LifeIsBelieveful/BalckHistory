package com.example.kcci.history101;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BlankFragment extends Fragment {
    Map<String, List<Map<String, String>>> childMap = new HashMap<String, List<Map<String, String>>>();
    List<Map<String, String>> childList1;
    Map<String, String> childDataMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);//프래그먼트 레이아웃 불러오기
        List<String> parentList = new ArrayList<String>(); //부모 메뉴 목록 입력
        parentList.add("임진왜란");
        parentList.add("병자호란");
        parentList.add("한국전쟁");
////////////////////////////////////////////////////////////////////////////////////////////////////
        //해쉬 맵과 리스트를 이용하여 데이터 입력//
        childList1 = new ArrayList<>();
        putdata("title", "다대포전투");
        putdata("title", "동래성전투");
        putdata("title", "경상도 및 충청도 함락");
        putdata("title", "상주전투");
        putdata("title", "용인전투");
        putdata("title", "웅치전투");
        putdata("title", "금산전투");
        putdata("title", "해정창전투");
        putdata("title", "영원산성전투");
        putdata("title", "벽제관전투");
        putdata("title", "제2차진주성전투");
        putdata("title", "칠천량해전");
        putdata("title", "남원전투");
        putdata("title", "황석산성전투");
        putdata("title", "제1차울산성전투");
        putdata("title", "사천성전투");
        putdata("title", "왜교성전투");
        putchilmap("0", childList1);

        putdata("title", "쌍령전투");
        putdata("title", "험천전투");
        putdata("title", "남한산성공방전");
        putdata("title", "병자호란");
        putdata("title", "강화도방어전");
        putdata("title", "험천전투");
        putchilmap("1", childList1);


        putdata("title", "제1차청천강전투");
        putdata("title", "제2차청천강전투");
        putdata("title", "온정리전투");
        putdata("title", "초산전투");
        putdata("title", "금성전투");
        putchilmap("2", childList1);

///////////////////////////////////////////////////////////////////////////////////////////////////
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.list_view);
        final CustomAdapter adapter = new CustomAdapter(getContext(),
                R.layout.parent, R.layout.child,
                parentList, childMap);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String da = Integer.toString(groupPosition);
                String d = childMap.get(da).get(childPosition).get("title");
                Intent intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("title", d);
                startActivity(intent);
                return false;
            }
        });
        return view;
    }

    public List<Map<String, String>> putdata(String title, String name) {
        childDataMap = new HashMap<String, String>();//맵 초기화
        childDataMap.put(title, name);//데이터 해쉬맵에 키값과 청천강전투 입력
        childList1.add(childDataMap);
        return childList1;
    }

    public Map<String, List<Map<String, String>>> putchilmap(String
                                                                     string, List<Map<String, String>> list) {
        childMap.put(string, list);
        childList1 = new ArrayList<>();
        return childMap;

    }
}
