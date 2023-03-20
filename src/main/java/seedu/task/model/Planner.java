package seedu.task.model;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import seedu.task.model.calendar.DailyPlan;

/**
 * Wraps all data at the planner level
 */
public class Planner implements ReadOnlyPlanner {

    private List<DailyPlan> plansList;

    {
        plansList = new ArrayList<DailyPlan>();
    }
    public Planner() {}

    /**
     * Creates a Planner using the DailyPlans in the {@code toBeCopied}
     */
    public Planner(ReadOnlyPlanner toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Replaces the contents of the DailyPlan list with {@code DailyPlan}
     */
    public void setDailyPlans(List<DailyPlan> plans) {
        plansList = new ArrayList<>();
        this.plansList.addAll(plans);
    }

    /**
     * Resets the existing data of this {@code Planner} with {@code newDailyPlans}.
     */
    public void resetData(ReadOnlyPlanner newDailyPlans) {
        requireNonNull(newDailyPlans);
        setDailyPlans(newDailyPlans.getDailyPlanList());
    }

    public void addDailyPlan(DailyPlan dp) {
        plansList.add(dp);
    }

    @Override
    public List<DailyPlan> getDailyPlanList() {
        return plansList;
    }

    public DailyPlan getDailyPlanOn(LocalDate date) {
        int n = plansList.size();

        for (int i = 0; i < n; i++) {
            if (plansList.get(i).getDate().isEqual(date)) {
                return plansList.get(i);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return plansList.size() + " daily plans";
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Planner
                && plansList.equals(((Planner) other).plansList));
    }

    @Override
    public int hashCode() {
        return plansList.hashCode();
    }
}
