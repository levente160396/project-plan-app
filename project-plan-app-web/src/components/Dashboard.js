import React, { Component } from "react";
import Projectitem from "./Project/Projectitem";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1>Wecome to the Dashboard</h1>;
        <Projectitem />
        <Projectitem />
        <Projectitem />
      </div>
    );
  }
}

export default Dashboard;