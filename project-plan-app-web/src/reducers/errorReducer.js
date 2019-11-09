import { GET_ERRORS } from "../actions/types";

const initialsState = {};

export default function(state = initialsState, action) {
  switch (action.type) {
    case GET_ERRORS:
      return action.payload;

    default:
      return state;
  }
}
