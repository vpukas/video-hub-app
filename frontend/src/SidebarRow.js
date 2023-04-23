import React from "react";
import "./SidebarRow.css";

function SidebarRow({ Icon, title }) {
  return (
    <div className="sidebarRow">
      <Icon className="sidebarRow__icon"  style={{ color: "#000000" }}/>
      <p className="sidebarRow__title" style={{ marginLeft: "10px", color: "white" }}>
        {title}
      </p>
    </div>
  );
}

export default SidebarRow;
