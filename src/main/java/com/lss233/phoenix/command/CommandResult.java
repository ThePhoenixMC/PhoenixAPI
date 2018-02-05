package com.lss233.phoenix.command;

/**
 *
 */
public class CommandResult {
    private final int affectedBlocks,affectedEntities,affectedItems,successCount,queryResult,invokedExecutors;
    private final Reason reason;

    private CommandResult(int affectedBlocks, int affectedEntities, int affectedItems, int successCount, int queryResult,int invokedExecutors, Reason reason) {
        this.affectedBlocks = affectedBlocks;
        this.affectedEntities = affectedEntities;
        this.affectedItems = affectedItems;
        this.successCount = successCount;
        this.queryResult = queryResult;
        this.invokedExecutors = invokedExecutors;
        this.reason = reason;
    }

    /**
     * Gets the number of blocks affected by the command.
     * @return The number of blocks affected by the command.
     */
    public int getAffectedBlocks() {
        return affectedBlocks;
    }

    /**
     * Gets the number of entities affected by the command.
     * @return The number of entities affected by the command.
     */
    public int getAffectedEntities() {
        return affectedEntities;
    }

    /**
     * Gets the number of items affected by the command.
     * @return The number of items affected by the command.
     */
    public int getAffectedItems() {
        return affectedItems;
    }

    /**
     * Gets the success count of the command.
     * @return The success count of the command
     */
    public int getSuccessCount() {
        return successCount;
    }

    /**
     * Gets the query result of the command,
     * @return The result of the command.
     */
    public int getQueryResult() {
        return queryResult;
    }

    /**
     * Gets the count of invoked executors of this command.
     * @return The count of invoked exectuors
     */
    public int getInvokedExecutors() {
        return invokedExecutors;
    }
    public static CommandResult.Builder builder() {
        return new Builder();
    }

    /**
     * Returns a result indicating the command was not processed successfully.
     * @return The command result.
     */
    public static CommandResult notFound() {
        return new Builder()
                .setReason(Reason.NOT_FOUND)
                .setSuccessCount(0)
                .build();
    }

    /**
     * Returns a result indicating the command was processed without affects.
     * @return The command result.
     */
    public static CommandResult success() {
        return new Builder().build();
    }

    /**
     * Gets the reason of the command result, none if success.
     * @return The reason of the command result.
     */
    public Reason getReason() {
        return reason;
    }

    /**
     * Returns a result indicating the command was not processed successfully
     * because of the permissions.
     * @return The command result.
     */
    public static CommandResult permissionDenied() {
        return new Builder()
                .setReason(Reason.NO_PERMISSION)
                .setSuccessCount(0)
                .build();
    }

    public enum Reason{
        NOT_FOUND,
        NO_PERMISSION,
        NONE,
    }

    public static class Builder {
        int affectedBlocks = 0;
        int affectedEntities = 0;
        int affectedItems = 0;
        int successCount = 0;
        int invokedExecutors = 0;
        int queryResult = 0;

        public int getInvokedExecutors() {
            return invokedExecutors;
        }

        public Builder setInvokedExecutors(int invokedExecutors) {
            this.invokedExecutors = invokedExecutors;
            return this;
        }
        Reason reason = Reason.NONE;

        public CommandResult build(){
            return new CommandResult(affectedBlocks, affectedEntities, affectedItems, successCount, queryResult, invokedExecutors, reason);
        }

        public Reason getReason() {
            return reason;
        }

        public Builder setReason(Reason reason) {
            this.reason = reason;
            return this;
        }

        public Builder append(CommandResult commandResult){
            queryResult += commandResult.getQueryResult();
            successCount += commandResult.getSuccessCount();
            affectedItems += commandResult.getAffectedItems();
            affectedBlocks += commandResult.getAffectedBlocks();
            affectedEntities += commandResult.getAffectedEntities();
            invokedExecutors ++;
            return this;
        }

        public int getAffectedBlocks() {
            return affectedBlocks;
        }

        public Builder setAffectedBlocks(int affectedBlocks) {
            this.affectedBlocks = affectedBlocks;
            return this;
        }

        public int getAffectedEntities() {
            return affectedEntities;
        }

        public Builder setAffectedEntities(int affectedEntities) {
            this.affectedEntities = affectedEntities;
            return this;
        }

        public int getAffectedItems() {
            return affectedItems;
        }

        public Builder setAffectedItems(int affectedItems) {
            this.affectedItems = affectedItems;
            return this;
        }

        public int getSuccessCount() {
            return successCount;
        }

        public Builder setSuccessCount(int successCount) {
            this.successCount = successCount;
            return this;
        }

        public int getQueryResult() {
            return queryResult;
        }

        public Builder setQueryResult(int queryResult) {
            this.queryResult = queryResult;
            return this;
        }
    }
}
