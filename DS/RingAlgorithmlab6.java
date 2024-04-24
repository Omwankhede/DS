import java.util.ArrayList;
import java.util.List;

public class RingAlgorithm {
    private int processId;
    private List<Integer> processes;

    public RingAlgorithm(int processId, List<Integer> processes) {
        this.processId = processId;
        this.processes = processes;
    }

    public void startElection() {
        System.out.println("Process " + processId + " initiates election.");

        int maxProcessId = processId;

        // Send election message to the next process in the ring
        int nextProcess = (processes.indexOf(processId) + 1) % processes.size();
        int firstProcess = nextProcess;

        while (true) {
            // Send election message to the next process
            System.out.println("Process " + processId + " sends election message to Process " + processes.get(nextProcess));

            // Receive OK message from the next process
            System.out.println("Process " + processId + " receives OK message from Process " + processes.get(nextProcess));

            // Check if the next process has a higher priority
            if (processes.get(nextProcess) > maxProcessId) {
                maxProcessId = processes.get(nextProcess);
            }

            // Move to the next process in the ring
            nextProcess = (nextProcess + 1) % processes.size();

            // If we have completed the full circle, break the loop
            if (nextProcess == firstProcess) {
                break;
            }
        }

        // Declare self as leader
        System.out.println("Process " + processId + " declares itself as the leader.");

        // Notify other processes about the new leader
        for (int p : processes) {
            if (p != processId) {
                // Notify process p about the new leader
                System.out.println("Process " + processId + " notifies Process " + p + " about the new leader " + maxProcessId);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> processes = new ArrayList<>();
        processes.add(1);
        processes.add(2);
        processes.add(3);
        processes.add(4);

        RingAlgorithm ringAlgorithm = new RingAlgorithm(3, processes);
        ringAlgorithm.startElection();
    }
}
